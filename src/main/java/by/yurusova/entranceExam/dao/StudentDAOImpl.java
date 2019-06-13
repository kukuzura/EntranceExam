package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Student;
import by.yurusova.entranceExam.entity.User;

import java.util.List;

public class StudentDAOImpl extends AbstractBaseDAO implements StudentDAO{

    @Override
    public Student findById(String passport_id) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        super.save(student);
    }

    @Override
    public void delete(Student student) {
        super.delete(student);
    }

    @Override
    public void update(Student student) {
        super.update(student);
    }

    @Override
    public List<Student> getAll() {
        List students= super.getAll("from Student");
        return (List<Student>)students;
    }
}
