package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Speciality;
import by.yurusova.entranceExam.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class StudentSpecialityDisplayController {

    @Autowired
    SpecialityService specialityService;


    @RequestMapping("specialityList")
    ModelAndView showSpecialityList() {
        ModelAndView mav = new ModelAndView("/specialityList.jsp");
        List<Speciality> specialities = specialityService.getAll();
        mav.addObject("specialityList", specialities);
        return mav;
    }

     @RequestMapping(value = "/username", method = RequestMethod.GET)
    public String currentUserName(Principal principal) {
        String login = principal.getName();
        return login;
    }


}
