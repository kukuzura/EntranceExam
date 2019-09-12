package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.dao.interfaces.GradeDAO;
import by.yurusova.entranceExam.dao.interfaces.SpecialityDAO;
import by.yurusova.entranceExam.dao.interfaces.StudentDAO;
import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Grade;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class ExamDAOFindByStudentTest {

    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private GradeDAO gradeDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private SpecialityDAO specialityDAO;

    private Long teacherId;

    private Long specialityId;

    private Long subjectId;

    private Long examId;

    private Long studentId;

    @Before
    public void before() {
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Student student = new Student();
        Grade grade = new Grade();
        Speciality speciality = new Speciality();
        studentId = studentDAO.saveStudent(student);
        grade.setStudent(student);
        teacherId = teacherDAO.saveTeacher(teacher);
        subjectId = subjectDAO.saveSubject(subject);
        specialityId = specialityDAO.saveSpeciality(speciality);
        exam.setSpeciality(speciality);
        exam.setTeacher(teacher);
        exam.setSubject(subject);
        examId = examDAO.saveExam(exam);
        grade.setExam(exam);
        gradeDAO.saveGrade(grade);
    }

    @Test
    public void test() {
        assertNotNull(examDAO.findByStudent(studentId));
    }

    @After
    public void after() {
        teacherDAO.delete(teacherDAO.findById(teacherId));
        subjectDAO.delete(subjectDAO.findById(subjectId));
        specialityDAO.delete(specialityDAO.findById(specialityId));
        examDAO.delete(examDAO.findById(examId));
    }

}
