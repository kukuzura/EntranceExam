package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.dao.interfaces.SpecialityDAO;
import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
@Rollback
public class ExamDeleteReferenceTest extends TestCase {

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
    public void before() {
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Speciality speciality = new Speciality();
        teacherId = teacherDAO.saveTeacher(teacher);
        subjectId = subjectDAO.saveSubject(subject);
        specialityId = specialityDAO.saveSpeciality(speciality);
        exam.setSpeciality(speciality);
        exam.setTeacher(teacher);
        exam.setSubject(subject);
        examId = examDAO.saveExam(exam);
    }

    @Test
    public void deleteExamReferences() {
        Teacher teacher = teacherDAO.findById(teacherId);
        teacherDAO.delete(teacher);
        assertNotNull(examDAO.findById(examId));
        Subject subject = subjectDAO.findById(subjectId);
        subjectDAO.delete(subject);
        assertNotNull(examDAO.findById(examId));
        Speciality speciality = specialityDAO.findById(specialityId);
        specialityDAO.delete(speciality);
        assertNotNull(examDAO.findById(examId));
    }

    @After
    public void after() {
        examDAO.delete(examDAO.findById(examId));
    }

}