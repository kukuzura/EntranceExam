package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.UserConverter;
import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * Method delete user by id.
     *
     * @param userID the id.
     */
    public void delete(final long userID) {
        userService.deleteUser(userID);
    }

    /**
     * Method gets all users from db and converts then to UserDTO.
     *
     * @return list of userDTO.
     */
    public List<UserDTO> getAll() {
        List<User> users = userService.getAll();
        List<UserDTO> dtoList = new ArrayList<UserDTO>();
        for (User user : users) {
            dtoList.add(userConverter.convert(user));
        }
        return dtoList;
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
        List<UserDTO> users = getAll();
        mav.addObject("usersList", users);
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
        User user = userConverter.convertBack(userDTO);
        userService.editUser(user);
    }
}
