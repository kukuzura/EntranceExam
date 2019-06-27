import by.yurusova.entranceExam.dao.ExamDAO;
import by.yurusova.entranceExam.dao.SpecialityDAO;
import by.yurusova.entranceExam.dao.SubjectDAO;
import by.yurusova.entranceExam.dao.TeacherDAO;
import by.yurusova.entranceExam.entity.Exam;
import by.yurusova.entranceExam.entity.Speciality;
import by.yurusova.entranceExam.entity.Subject;
import by.yurusova.entranceExam.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class ExamDAOImplTest {

    @Autowired
    ExamDAO examDAO;

    @Autowired
    SpecialityDAO specialityDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    TeacherDAO teacherDAO;


    @Test
    public void testSaveExam() {
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        Subject subject = new Subject();
        subject.setId(1);
        Speciality speciality = new Speciality();
        speciality.setId(1);
        specialityDAO.saveSpeciality(speciality);
        subjectDAO.saveSubject(subject);
        teacherDAO.saveTeacher(teacher);


        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        exam.setTeacher(teacher);

        examDAO.saveExam(exam);
        List<Exam> exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
    }

    @Test
    public void testDeleteExamReferencedEntities() {
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        Subject subject = new Subject();
        subject.setId(1);
        Speciality speciality = new Speciality();
        speciality.setId(1);


        speciality.setExams(Arrays.asList(exam));

        specialityDAO.saveSpeciality(speciality);
        subjectDAO.saveSubject(subject);
        teacherDAO.saveTeacher(teacher);

        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        exam.setTeacher(teacher);

        examDAO.saveExam(exam);

        specialityDAO.delete(speciality);
        List<Exam> exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
        subjectDAO.delete(subject);
        exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
        teacherDAO.delete(teacher);
        exams = examDAO.getAll();
        assertEquals("table is empty", 1, exams.size());
    }

    @Test
    public void testDeleteExam() {
        Exam exam = new Exam();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        Subject subject = new Subject();
        subject.setId(1);
        Speciality speciality = new Speciality();
        speciality.setId(1);


        speciality.setExams(Arrays.asList(exam));

        specialityDAO.saveSpeciality(speciality);
        subjectDAO.saveSubject(subject);
        teacherDAO.saveTeacher(teacher);

        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        exam.setTeacher(teacher);

        examDAO.saveExam(exam);

        examDAO.delete(exam);
        List<Speciality> specialities = specialityDAO.getAll();
        assertEquals("speciality table is empty", 1, specialities.size());
        List<Teacher> teachers=teacherDAO.getAll();
        assertEquals("teachers table is empty", 1,teachers.size());
        List<Subject> subjects=subjectDAO.getAll();
        assertEquals("subjects table is empty", 1,subjects.size());
    }
}