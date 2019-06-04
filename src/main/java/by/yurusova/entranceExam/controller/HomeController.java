package by.yurusova.entranceExam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView showHome(){
        ModelAndView home = new ModelAndView("/index.jsp");
        return home;
    }

}
