package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.ExamDAO;
import by.yurusova.entranceExam.dao.SpecialityDAO;
import by.yurusova.entranceExam.dao.SubjectDAO;
import by.yurusova.entranceExam.dao.TeacherDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class ExamDAOImplTest {

    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private SpecialityDAO specialityDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @BeforeAll
    public void before() {
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Speciality speciality = new Speciality();
        specialityDAO.saveSpeciality(speciality);
        subjectDAO.saveSubject(subject);
        teacherDAO.saveTeacher(teacher);
        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        exam.setTeacher(teacher);
        examDAO.saveExam(exam);
    }

    @Test
    public void testSaveExam() {
        List<Exam> exams = examDAO.getAll();
        assertNotNull(exams);
        assertEquals("table is empty", 1, exams.size());
    }

    @After
    public void after(){
        Teacher teacher = teacherDAO.findById(1);
        Speciality speciality = specialityDAO.findById(1);
        Subject subject = subjectDAO.findById(1);
        List<Exam> exams = examDAO.getAll();
    }

    @Before
    public void beforeDeleteReferences() {
        Teacher teacher = teacherDAO.findById(1);
        Speciality speciality = specialityDAO.findById(1);
        Subject subject = subjectDAO.findById(1);
        specialityDAO.delete(speciality);
        subjectDAO.delete(subject);
        teacherDAO.delete(teacher);
    }

    @Test
    public void testDeleteExamReferencedEntities() {
        List<Exam> exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
        exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
        exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
    }

    @Before
    public void beforeDeleteExam() {
        Exam exam = new Exam();
        exam.setId(1);
        examDAO.delete(exam);
    }

    @Test
    public void testDeleteExam() {
        List<Speciality> specialities = specialityDAO.getAll();
        assertEquals("speciality table is empty", 1, specialities.size());
        List<Teacher> teachers = teacherDAO.getAll();
        assertEquals("teachers table is empty", 1, teachers.size());
        List<Subject> subjects = subjectDAO.getAll();
        assertEquals("subjects table is empty", 1, subjects.size());
    }
}