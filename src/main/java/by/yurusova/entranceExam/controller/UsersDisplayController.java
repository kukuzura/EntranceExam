package by.yurusova.entranceExam.controller;

import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UsersDisplayController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView showAllUsers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }


}
