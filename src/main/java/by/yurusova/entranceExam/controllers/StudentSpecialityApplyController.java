package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.facades.ApplyingToSpecialityFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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

    /**
     * Method apply student to speciality with given id.
     *
     * @param id        the id.
     * @param principal object that contains username.
     * @param httpServletRequest request information.
     * @return student information page.
     */
    @RequestMapping(value = "apply/{id}", method = RequestMethod.GET)
    String applyToSpeciality(@PathVariable("id") final long id,
                             final Principal principal,
                             final HttpServletRequest httpServletRequest) {
        applyingToSpecialityFacade.applyToSpeciality(id, principal);
        String contextPath = httpServletRequest.getContextPath();
        return "redirect:" + contextPath + "/account/studentPage";
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
