package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     *
     * @param student
     */
    void addStudent(Student student);


    void deleteStudent(String passwordId);


    void editStudent(Student student);


    List<Student> getAll();


    public Student findById(String password_id);
}

