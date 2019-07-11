package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.interfaces.StudentDAO;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.services.interfaces.StudentService;

import java.util.List;

/**
 * Class that perform base student services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Override
    public void addStudent(final Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public void deleteStudent(final long id) {
        Student student = new Student();
        student.setId(id);
        studentDAO.delete(student);
    }

    @Override
    public void editStudent(final Student student) {
        studentDAO.update(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Student findById(final long id) {
        return studentDAO.findById(id);
    }

    @Override
    public Student findByPassportID(final String passportID) {
        return studentDAO.findByPassportID(passportID);
    }

    @Override
    public List<Student> findByExamID(final long examID) {
        return studentDAO.findByExamID(examID);
    }


    /**
     * Sets studentDAO.
     *
     * @param studentDAO studentDAO to be set
     */
    public void setStudentDAO(final StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}

