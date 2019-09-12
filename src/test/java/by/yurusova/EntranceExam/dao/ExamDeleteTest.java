package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.dao.interfaces.SpecialityDAO;
import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
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

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class ExamDeleteTest {

    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private SpecialityDAO specialityDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    private Long teacherId;

    private Long specialityId;

    private Long subjectId;

    private Long examId;

    @Before
    public void beforeSave() {
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Speciality speciality = new Speciality();
        teacherId = teacherDAO.saveTeacher(teacher);
        subjectId = subjectDAO.saveSubject(subject);
        specialityId = specialityDAO.saveSpeciality(speciality);
        Exam exam = new Exam();
        exam.setSpeciality(speciality);
        exam.setTeacher(teacher);
        exam.setSubject(subject);
        examId = examDAO.saveExam(exam);
    }

    @Test
    public void deleteExamTest() {
        examDAO.delete(examDAO.findById(examId));
        Teacher teacher = teacherDAO.findById(teacherId);
        Subject subject = subjectDAO.findById(subjectId);
        Speciality speciality = specialityDAO.findById(specialityId);
        assertNotNull(teacher);
        assertNotNull(speciality);
        assertNotNull(subject);
    }

    @After
    public void after() {
        teacherDAO.delete(teacherDAO.findById(teacherId));
        specialityDAO.delete(specialityDAO.findById(specialityId));
        subjectDAO.delete(subjectDAO.findById(subjectId));
    }
}

