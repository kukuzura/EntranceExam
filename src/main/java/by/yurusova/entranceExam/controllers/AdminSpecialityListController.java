package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.facades.SpecialityOperationsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for speciality list page and all admin operation with specialities.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/admin")
public class AdminSpecialityListController {

    @Autowired
    private SpecialityOperationsFacade specialityOperationsFacade;

    /**
     * Method returns page with list of specialties.
     *
     * @return the page.
     */
    @RequestMapping("/specialityList")
    public ModelAndView createSpecialityList() {
        return specialityOperationsFacade.createSpecialityList();
    }

    /**
     * Method deletes speciality from database by it's id.
     *
     * @param id the speciality id.
     * @return speciality list page.
     */
    @RequestMapping(value = "/specialityDelete/{id}")
    public ModelAndView showEdit(@PathVariable("id") final long id) {
        specialityOperationsFacade.deleteSpeciality(id);
        return specialityOperationsFacade.createSpecialityList();
    }

    /**
     * Method return page for adding speciality.
     *
     * @return speciality adding page.
     */
    @RequestMapping(value = "/addSpeciality", method = RequestMethod.GET)
    public ModelAndView showAddingPage() {
        ModelAndView modelAndView = new ModelAndView("/addSpeciality.jsp");
        modelAndView.addObject("speciality", new SpecialityDTO());
        return modelAndView;
    }

    /**
     * Method converts specialityDTO to speciality
     * and saves it to database.
     *
     * @param specialityDTO dto to be convert
     * @return speciality list page.
     */
    @RequestMapping(value = "/addSpeciality", method = RequestMethod.POST)
    public ModelAndView addExam(@ModelAttribute("speciality") final SpecialityDTO specialityDTO) {
        specialityOperationsFacade.addSpeciality(specialityDTO);
        return specialityOperationsFacade.createSpecialityList();
    }

}
