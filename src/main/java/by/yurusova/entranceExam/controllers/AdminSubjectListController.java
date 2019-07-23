package by.yurusova.entranceExam.controllers;


import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.facades.SubjectOperationsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for subject list page and all admin operation with subjects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/admin")
public class AdminSubjectListController {

    @Autowired
    private SubjectOperationsFacade subjectOperationsFacade;

    /**
     * Method shows page with list of specialities.
     *
     * @return speciality list page.
     */
    @RequestMapping("subjectList")
    public ModelAndView showSubjectList() {
        return subjectOperationsFacade.createSubjectList();
    }

    /**
     * Method delete subject from database by its id.
     *
     * @param id id of subject ot be delete.
     * @return speciality list page.
     */
    @RequestMapping(value = "/subjectDelete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") final long id) {
        subjectOperationsFacade.deleteSubject(id);
        return subjectOperationsFacade.createSubjectList();
    }

    /**
     * Method shows subject adding page
     * and sets on in subjectDTO object as modelAttribute subject.
     *
     * @return adding page.
     */
    @RequestMapping(value = "/addSubject", method = RequestMethod.GET)
    public ModelAndView showAddPage() {
        ModelAndView modelAndView = new ModelAndView("/addSubject.jsp");
        modelAndView.addObject("subject", new SubjectDTO());
        return modelAndView;
    }

    /**
     * Method converts subjectDTO to subject and saves it to database.
     *
     * @param subjectDTO dto to be convert.
     * @return speciality list page.
     */
    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public ModelAndView addExam(@ModelAttribute("subject") final SubjectDTO subjectDTO) {
        subjectOperationsFacade.addSubject(subjectDTO);
        return subjectOperationsFacade.createSubjectList();
    }
}
