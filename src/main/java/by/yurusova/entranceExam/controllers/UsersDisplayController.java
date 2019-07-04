package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * User list page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping(value = "/admin")
public class UsersDisplayController {

    @Resource(name = "userService")
    private UserService userService;

    /**
     * Show list of user.
     *
     * @return page with list of users.
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView showAllUsers() {
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }

    /**
     * Method shows edit page (for user with given id).
     *
     * @param id the user id.
     * @return edit page.
     */
    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView showEdit(@PathVariable("id") final long id) {
        ModelAndView mav = new ModelAndView("/userUpdate.jsp");
        User user = userService.findById(id);
        mav.addObject("user", user);
        return mav;
    }

    /**
     * Method updates user information.
     *
     * @param user the user to update.
     * @return page with updated list of users.
     */
    @RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") final User user) {
        userService.editUser(user);
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }

    /**
     * Method delete user with given id.
     *
     * @param id the id of deleed user.
     * @return updated user list page.
     */
    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.GET)
    public ModelAndView showDelete(@PathVariable("id") final long id) {
        userService.deleteUser(id);
        ModelAndView mav = new ModelAndView("/userList.jsp");
        List<User> users = userService.getAll();
        mav.addObject("usersList", users);
        return mav;
    }


}
