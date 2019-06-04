package by.yurusova.entranceExam.controller;

import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.UserService;
import by.yurusova.entranceExam.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UsersDisplayController {

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView showAllUsers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }

    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView showEdit(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("/userUpdate.jsp");
        User user = userService.findById(id);
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
    public ModelAndView updateUser( HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
        userService.editUser(user);
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }


    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.GET)
    public ModelAndView showDelete(@PathVariable("id") long id){
        userService.deleteUser(id);
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }





}
