package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class UsersDisplayController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView showAllUsers() {
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }

    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView showEdit(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("/userUpdate.jsp");
        User user = userService.findById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }


    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.GET)
    public ModelAndView showDelete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }


}
