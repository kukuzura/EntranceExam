package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.StudentReverseConverter;
import by.yurusova.entranceExam.converters.UserReverseConverter;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.RoleService;
import by.yurusova.entranceExam.services.StudentService;
import by.yurusova.entranceExam.services.UserService;

import java.util.Arrays;

/**
 * Facade for registration.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class RegistrationFacade {

    private UserService userService;

    private StudentService studentService;

    private RoleService roleService;

    private StudentReverseConverter studentReverseConverter;

    private UserReverseConverter userReverseConverter;

    /**
     * Sets role service.
     *
     * @param roleService role service to be set.
     */
    public void setRoleService(final RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Sets user reverse converter.
     *
     * @param userReverseConverter reverse converter to be set.
     */
    public void setUserReverseConverter(final UserReverseConverter userReverseConverter) {
        this.userReverseConverter = userReverseConverter;
    }

    /**
     * Sets student service.
     *
     * @param studentService student service to be set.
     */
    public void setStudentService(final StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Sets student reverse converter.
     *
     * @param studentReverseConverter reverse converter to be set.
     */
    public void setStudentReverseConverter(final StudentReverseConverter studentReverseConverter) {
        this.studentReverseConverter = studentReverseConverter;
    }

    /**
     * Sets user service.
     *
     * @param userService user service to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Method adds student and user to db.
     *
     * @param userDTO    user
     * @param studentDTO student
     */
    public void registerStudent(final UserDTO userDTO, final StudentDTO studentDTO) {
        User user = userReverseConverter.convert(userDTO);
        Student student = studentReverseConverter.convert(studentDTO);
        user.setRoles(Arrays.asList(roleService.findByName("ROLE_STUDENT")));
        student.setUser(user);
        userService.addUser(user);
        studentService.addStudent(student);
    }
}
