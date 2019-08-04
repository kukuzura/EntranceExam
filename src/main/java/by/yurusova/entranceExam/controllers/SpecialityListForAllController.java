package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.properties.ApplicationProperties;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for speciality list page for not authorized users.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class SpecialityListForAllController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ApplicationProperties properties;

    /**
     * Method creates ModelAndView for speciality list page
     * and sets on it list of specialities.
     *
     * @return the ModelAndView
     */
    @RequestMapping("/specialityList")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/specialityListForAll.jsp");
        modelAndView.addObject("specialityList",
                specialityService.getAllWithExamsAmount(Integer.valueOf(properties.getExamAmount())));
        return modelAndView;
    }

    /**
     * Sets speciality service.
     *
     * @param specialityService service to be set.
     */
    public void setSpecialityService(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    /**
     * Sets object that contains application constants.
     *
     * @param properties the object.
     */
    public void setProperties(final ApplicationProperties properties) {
        this.properties = properties;
    }

}
