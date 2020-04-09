package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.dto.StudentTestsInfoDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.facades.ApplyingToSpecialityFacade;
import by.yurusova.entranceExam.facades.SpecialityOperationsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * List of speciality page(for student) controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/account")
public class StudentSpecialityApplyController {

    @Autowired
    private ApplyingToSpecialityFacade applyingToSpecialityFacade;

    @Autowired
    private SpecialityOperationsFacade specialityOperationsFacade;

    /**
     * Method apply student to speciality with given id.
     *
     * @param id                 the id.
     * @param principal          object that contains username.
     * @param httpServletRequest request information.
     * @return student information page.
     */
    @RequestMapping(value = "apply/{id}", method = RequestMethod.GET)
    String applyToSpeciality(@PathVariable("id") final long id,
                             final Principal principal,
                             final HttpServletRequest httpServletRequest) {
        applyingToSpecialityFacade.applyToSpeciality(id, principal);
        return "redirect: ../studentPage";
    }

    @RequestMapping(value = "applyWithTest/{id}", method = RequestMethod.GET)
    ModelAndView getApplyWithTestPage(@PathVariable("id") final Long id, final Principal principal) {
        return specialityOperationsFacade.createApplyToSpecialityWithTestPage(id);
    }

    @RequestMapping(value = "applyWithTest/{id}", method = RequestMethod.POST)
    String applyToSpecialityWithTestResults(@PathVariable("id") final long id,
                                            @ModelAttribute("studentInfo") final StudentTestsInfoDTO studentInfo,
                                            final Principal principal) {
        applyingToSpecialityFacade.applyToSpecialityWithTest(id, principal,studentInfo);
        return "redirect: ../studentPage";
    }

    /**
     * Method shows speciality list.
     *
     * @return page with list of specialities.
     */
    @RequestMapping("specialityList")
    ModelAndView showSpecialityList() {
        return applyingToSpecialityFacade.createSpecialityListPage();
    }
}
