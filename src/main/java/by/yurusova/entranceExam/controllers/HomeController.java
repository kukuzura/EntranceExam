package by.yurusova.entranceExam.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    /**
     * Method shows home page
     *
     * @return home page
     */
    @RequestMapping(value = "/")
    public String showHome() {
        return "/index.jsp";
    }

}
