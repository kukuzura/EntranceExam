package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.dao.interfaces.SpecialityDAO;
import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
@Rollback
public class ExamDAOFindBySpeciality {

    @Autowired
    ExamDAO examDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    SpecialityDAO specialityDAO;

    @Before
    public void beforeDeleteReference(){
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Speciality speciality = new Speciality();
        teacher.setId(1);
        speciality.setId(1);
        subject.setId(1);
        teacherDAO.saveTeacher(teacher);
        subjectDAO.saveSubject(subject);
        specialityDAO.saveSpeciality(speciality);
        exam.setSpeciality(speciality);
        exam.setTeacher(teacher);
        exam.setSubject(subject);
        examDAO.saveExam(exam);
    }

    @Test
    @Rollback
    public void deleteExamReferences(){
        assertNotNull(examDAO.findBySpeciality(1));
    }

//    @After
//    public void after(){
//        teacherDAO.delete(teacherDAO.findById(1));
//        subjectDAO.delete(subjectDAO.findById(1));
//        specialityDAO.delete(specialityDAO.findById(1));
//        examDAO.delete(examDAO.findById(1));
//    }

}
