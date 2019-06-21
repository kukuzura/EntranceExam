package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.StudentDAO;
import by.yurusova.entranceExam.entity.Student;

import java.util.List;

/**
 * Class that performe base student services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
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
    public void deleteStudent(final String id) {
        Student student = new Student();
        student.setPassportID(id);
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
    public Student findById(final String id) {
        return studentDAO.findById(id);
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

