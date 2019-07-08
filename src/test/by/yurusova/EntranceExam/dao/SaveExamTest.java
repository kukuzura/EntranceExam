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

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class SaveExamTest {

    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private SpecialityDAO specialityDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Before
    public void beforeSave() {
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Speciality speciality = new Speciality();
        teacher.setId(1);
        speciality.setId(1);
        subject.setId(1);
        teacherDAO.saveTeacher(teacher);
        subjectDAO.saveSubject(subject);
        specialityDAO.saveSpeciality(speciality);
    }

    @Test
    public void saveExamTest() {
        Exam exam = new Exam();
        Teacher teacher = teacherDAO.findById(1);
        Subject subject = subjectDAO.findById(1);
        Speciality speciality = specialityDAO.findById(1);
        exam.setSpeciality(speciality);
        exam.setTeacher(teacher);
        exam.setSubject(subject);
        examDAO.saveExam(exam);
        assertEquals("table is empaty", 1, examDAO.getAll().size());
    }


}
