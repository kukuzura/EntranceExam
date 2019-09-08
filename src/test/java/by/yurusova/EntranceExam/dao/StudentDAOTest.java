package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.StudentDAO;
import by.yurusova.entranceExam.dao.interfaces.UserDAO;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private UserDAO userDAO;

    private Long userId;

    private Long studentId;

    @Before
    public void beforeStudentSave() {
        User user = new User();
        Student student = new Student();
        student.setUser(user);
        userId = userDAO.saveUser(user);
        studentId = studentDAO.saveStudent(student);

    }

    @Test
    public void testSave() {
        assertEquals("check student saves", 1, studentDAO.getAll().size());
    }

    @Test
    public void deleteStudentTest() {
        studentDAO.delete(studentDAO.findById(studentId));
        assertEquals("should be 0", 0, studentDAO.getAll().size());
    }

    @Test
    public void updateStudentTest() {
        Student student = studentDAO.findById(studentId);
        student.setFirstName("name");
        studentDAO.update(student);
        student = studentDAO.findById(studentId);
        assertEquals("should be name", "name", student.getFirstName());
    }
}
