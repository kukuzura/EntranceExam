package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.StudentReverseConverter;
import by.yurusova.entranceExam.converters.TeacherReverseConverter;
import by.yurusova.entranceExam.converters.UserReverseConverter;
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

    private StudentReverseConverter studentReverseConverter;

    private UserReverseConverter userReverseConverter;

    private TeacherReverseConverter teacherReverseConverter;

    /**
     * Sets teacher reverse converter.
     *
     * @param teacherReverseConverter converter to be set.
     */
    public void setTeacherReverseConverter(final TeacherReverseConverter teacherReverseConverter) {
        this.teacherReverseConverter = teacherReverseConverter;
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
     * @param userReverseConverter reverse converter to be set.
     */
    public void setUserReverseConverter(final UserReverseConverter userReverseConverter) {
        this.userReverseConverter = userReverseConverter;
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
        userService.addUser(user);
        student.setUser(user);
        studentService.addStudent(student);
    }

    /**
     * Method adds teacher and user to db.
     *
     * @param userDTO    user
     * @param teacherDTO teacher
     */
    public void registerTeacher(final UserDTO userDTO, final TeacherDTO teacherDTO) {
        User user = userReverseConverter.convert(userDTO);
        Teacher teacher = teacherReverseConverter.convert(teacherDTO);
        user.setRoles(Arrays.asList(roleService.findByName("ROLE_TEACHER")));
        userService.addUser(user);
        teacher.setUser(user);
        teacherService.addTeacher(teacher);
    }
}
