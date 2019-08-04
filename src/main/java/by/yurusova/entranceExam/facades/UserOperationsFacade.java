package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.UserConverter;
import by.yurusova.entranceExam.converters.UserListConverter;
import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.web.servlet.ModelAndView;

/**
 * Facade for operations with users.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserOperationsFacade {

    private UserService userService;

    private UserConverter userConverter;

    private UserListConverter userListConverter;


    /**
     * Method delete user by id.
     *
     * @param userID the id.
     */
    public void delete(final long userID) {
        userService.deleteUser(userID);
    }

    /**
     * Method gets user by id and convert it to userDTO.
     *
     * @param id the id.
     * @return the userDTO.
     */
    public UserDTO findById(final long id) {
        User user = userService.findById(id);
        return userConverter.convert(user);
    }

    /**
     * Sets user service.
     *
     * @param userService service to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Sets user converter.
     *
     * @param userConverter converter to be set.
     */
    public void setUserConverter(final UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    /**
     * Method creates ModelAndView for user list.
     *
     * @return page with list of users.
     */
    public ModelAndView createUserListPage() {
        ModelAndView mav = new ModelAndView("/userList.jsp");
        mav.addObject("usersList", userListConverter.convertList(userService.getAll()));
        return mav;
    }

    /**
     * Method creates modelAndView for update.
     *
     * @param id id of user to update.
     * @return user update page.
     */
    public ModelAndView createUpdatePage(final long id) {
        ModelAndView mav = new ModelAndView("/userUpdate.jsp");
        User user = userService.findById(id);
        mav.addObject("user", user);
        return mav;
    }

    /**
     * Method converts UserDTO to user
     * and updates it in db.
     *
     * @param userDTO userDTO to be update.
     */
    public void update(final UserDTO userDTO) {
        User user = userService.findById(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        userService.editUser(user);
    }

    /**
     * Sets user list converter.
     *
     * @param userListConverter converter to be set.
     */
    public void setUserListConverter(final UserListConverter userListConverter) {
        this.userListConverter = userListConverter;
    }
}
