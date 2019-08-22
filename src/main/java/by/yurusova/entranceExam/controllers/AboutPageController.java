package by.yurusova.entranceExam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AboutPageController {

    @RequestMapping("/about")
    public String showAboutPage() {
        return "/about.jsp";
    }
}
