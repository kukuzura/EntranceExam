package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.StudentDAO;
import by.yurusova.entranceExam.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Override
    public void addStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public void deleteStudent(String passwordId) {
        Student student = new Student();
        student.setPassportID(passwordId);
        studentDAO.delete(student);
    }

    @Override
    public void editStudent(Student student) {
        studentDAO.update(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Student findById(String password_id) {
        return studentDAO.findById(password_id);
    }


    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}

