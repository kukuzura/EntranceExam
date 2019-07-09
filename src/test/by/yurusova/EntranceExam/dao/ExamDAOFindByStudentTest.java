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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class ExamDAOFindByStudentTest {

    @Autowired
    ExamDAO examDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    GradeDAO gradeDAO;

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    SpecialityDAO specialityDAO;

    @Before
    public void before(){
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Student student = new Student();
        Grade grade = new Grade();
        Speciality speciality = new Speciality();
        teacher.setId(1);
        speciality.setId(1);
        subject.setId(1);
        student.setId(1);
        studentDAO.saveStudent(student);
        grade.setStudent(student);
        teacherDAO.saveTeacher(teacher);
        subjectDAO.saveSubject(subject);
        specialityDAO.saveSpeciality(speciality);
        exam.setSpeciality(speciality);
        exam.setTeacher(teacher);
        exam.setSubject(subject);
        examDAO.saveExam(exam);
        grade.setExam(exam);
        gradeDAO.saveGrade(grade);
    }

    @Test
    public void test(){
        List<Grade> grades = gradeDAO.getAll();
        assertNotNull(examDAO.findByStudent(1));
    }
}
