package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.facades.UserOperationsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


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

    @Autowired
    private UserOperationsFacade facade;

    /**
     * Show list of user with pagination.
     *
     * @param page page number
     * @return page with list of users.
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView showAllUser(@RequestParam(required = false) final String page) {
        try {
            Integer.parseInt(page);
        }
        catch (NumberFormatException e) {
            return facade.createUserListPage(1);
        }
        return facade.createUserListPage(Integer.valueOf(page));
    }

    /**
     * Method shows edit page (for user with given id).
     *
     * @param id the user id.
     * @return edit page.
     */

    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView showEdit(@PathVariable("id") final long id) {
        return facade.createUpdatePage(id);
    }

    /**
     * Method updates user information.
     *
     * @param userDTO userDTO to convert to user.
     */
    @RequestMapping(value = "/updateProcess", method = RequestMethod.PUT)
    public void updateUser(@RequestBody final UserDTO userDTO) {
        facade.update(userDTO);
    }

    /**
     * Method delete user with given id.
     *
     * @param id the id of deleted user.
     */
    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void showDelete(@PathVariable("id") final long id) {
        facade.delete(id);
    }

    /**
     * Sets user operations facade.
     *
     * @param facade facade to be set.
     */
    public void setFacade(final UserOperationsFacade facade) {
        this.facade = facade;
    }

}
