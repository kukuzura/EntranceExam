package by.yurusova.EntranceExam.facade;

import by.yurusova.entranceExam.converters.StudentConverter;
import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.dao.interfaces.GradeDAO;
import by.yurusova.entranceExam.dao.interfaces.SpecialityDAO;
import by.yurusova.entranceExam.dao.interfaces.StudentDAO;
import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.dao.interfaces.UserDAO;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Grade;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.facades.RateFacade;
import org.hibernate.NonUniqueResultException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test.xml", "classpath:test-database.xml"})
@Transactional
public class ExampleFacadeTest {

    @Autowired
    private RateFacade rateFacade;

    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private SpecialityDAO specialityDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private GradeDAO gradeDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StudentConverter studentConverter;

    private Long firstUserId;

    private Long secondUserId;

    private Long studentId;

    private Long teacherId;

    private Long examId;

    private Long firstGradeId;

    private Long secondGradeId;

    private Long subjectId;

    private Long specialityId;

    @Before
    public void beforeTest() {
        firstUserId = userDAO.saveUser(new User("login1", "password"));
        secondUserId = userDAO.saveUser(new User("login2", "password"));
        Teacher teacher = new Teacher();
        teacher.setUser(userDAO.findById(firstUserId));
        teacher.setFirstName("first name");
        teacher.setLastName("last name");
        teacher.setPatronymic("patronymic");
        teacherId = teacherDAO.saveTeacher(teacher);
        Student student = new Student();
        student.setFirstName("first name");
        student.setLastName("last name");
        student.setPassportID("patronymic");
        student.setPatronymic("1234567");
        student.setUser(userDAO.findById(firstUserId));
        studentId = studentDAO.saveStudent(student);
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        specialityId = specialityDAO.saveSpeciality(speciality);
        Subject subject = new Subject();
        subject.setName("subject");
        subjectId = subjectDAO.saveSubject(subject);
        Exam exam = new Exam();
        exam.setSubject(subjectDAO.findById(subjectId));
        exam.setSpeciality(specialityDAO.findById(specialityId));
        exam.setTeacher(teacherDAO.findById(teacherId));
        examId = examDAO.saveExam(exam);
        Grade grade = new Grade();
        grade.setExam(exam);
        grade.setStudent(student);
        speciality.setExams(Arrays.asList(exam));
        specialityDAO.update(speciality);
        firstGradeId = gradeDAO.saveGrade(grade);
    }

    @Test
    public void testWithoutRollback() {
        StudentDTO studentDTO = studentConverter.convert(studentDAO.findById(studentId));
        studentDTO.setId(studentId);
        rateFacade
                .rateStudents(Arrays.asList(studentDTO), examId);
        Exam exam = examDAO.findById(examId);
        assertTrue("exam should be graded", exam.isGraded());
    }

    @After
    public void after(){
        examDAO.delete(examDAO.findById(examId));
        specialityDAO.delete(specialityDAO.findById(specialityId));
        studentDAO.delete(studentDAO.findById(studentId));
        subjectDAO.delete(subjectDAO.findById(subjectId));
        userDAO.delete(userDAO.findById(firstUserId));
        userDAO.delete(userDAO.findById(secondUserId));

    }

    @Test
    public void testFails() {
        Grade grade = new Grade();
        grade.setExam(examDAO.findById(examId));
        grade.setStudent(studentDAO.findById(studentId));
        secondGradeId = gradeDAO.saveGrade(grade);
        StudentDTO studentDTO = studentConverter.convert(studentDAO.findById(studentId));
        studentDTO.setId(studentId);
        try {
            rateFacade
                    .rateStudents(Arrays.asList(studentDTO), examId);
        }
        catch (NonUniqueResultException ex){ }
        Exam exam = examDAO.findById(examId);
        assertFalse("exam should be not graded", exam.isGraded());
    }
}

