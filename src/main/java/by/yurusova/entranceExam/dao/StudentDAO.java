package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Student;

import java.util.List;

public interface StudentDAO {

    /**
     * @param passportId
     * @return
     */
    Student findById(String passportId);

    void saveStudent(Student student);

    void delete(Student student);

    void update(Student student);

    List<Student> getAll();
}
