package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.StudentConverter;
import by.yurusova.entranceExam.converters.TeacherConverter;
import by.yurusova.entranceExam.converters.UserConverter;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.RoleService;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import by.yurusova.entranceExam.services.interfaces.TeacherService;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

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

    private TeacherService teacherService;

    private RoleService roleService;

    private StudentConverter studentConverter;

    private UserConverter userConverter;

    private TeacherConverter teacherConverter;

    /**
     * Sets teacher converter.
     *
     * @param teacherConverter converter to be set.
     */
    public void setTeacherConverter(final TeacherConverter teacherConverter) {
        this.teacherConverter = teacherConverter;
    }

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
     * @param userConverter reverse converter to be set.
     */
    public void setUserConverter(final UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    /**
     * Sets teacher service.
     *
     * @param teacherService teacher service to be set.
     */
    public void setTeacherService(final TeacherService teacherService) {
        this.teacherService = teacherService;
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
     * @param studentConverter reverse converter to be set.
     */
    public void setStudentConverter(final StudentConverter studentConverter) {
        this.studentConverter = studentConverter;
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
     * Method converts UserDto and StudentDTO to User and Student
     * and saves it to db.
     *
     * @param userDTO    user
     * @param studentDTO student
     */
    @Transactional
    public void registerStudent(final UserDTO userDTO, final StudentDTO studentDTO) {
        User user = userConverter.convertBack(userDTO);
        Student student = studentConverter.convertBack(studentDTO);
        user.setRoles(Arrays.asList(roleService.findByName("ROLE_STUDENT")));
        userService.addUser(user);
        student.setUser(user);
        studentService.addStudent(student);
    }

    /**
     * Method converts UserDto and TeacherDTO to User and Teacher
     * and saves the to db.
     *
     * @param userDTO    user
     * @param teacherDTO teacher
     */
    @Transactional
    public void registerTeacher(final UserDTO userDTO, final TeacherDTO teacherDTO) {
        User user = userConverter.convertBack(userDTO);
        Teacher teacher = teacherConverter.convertBack(teacherDTO);
        user.setRoles(Arrays.asList(roleService.findByName("ROLE_TEACHER")));
        userService.addUser(user);
        teacher.setUser(user);
        teacherService.addTeacher(teacher);
    }

    /**
     * Method creates ModelAndView for student registration page
     * and sets on it UserDTO and StudentDTO.
     *
     * @return student registration page.
     */
    public ModelAndView createStudentRegistrationPage() {
        ModelAndView mav = new ModelAndView("/studentRegistration.jsp");
        mav.addObject("user", new UserDTO());
        mav.addObject("student", new StudentDTO());
        return mav;
    }

    /**
     * Method creates ModelAndView for teacher registration page
     * and sets on it UserDTO and TeacherDTO.
     *
     * @return teacher registration page.
     */
    public ModelAndView createTeacherRegistrationPage() {
        ModelAndView mav = new ModelAndView("/teacherRegistration.jsp");
        mav.addObject("user", new UserDTO());
        mav.addObject("teacher", new TeacherDTO());
        return mav;
    }
}
