package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Student;

import java.util.List;

/**
 * Class responsible for operations with student table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentDAOImpl extends AbstractBaseDAO implements StudentDAO {

    @Override
    public Student findById(final String passportId) {
        return null;
    }

    @Override
    public void saveStudent(final Student student) {
        super.save(student);
    }

    @Override
    public void delete(final Student student) {
        super.delete(student);
    }

    @Override
    public void update(final Student student) {
        super.update(student);
    }

    @Override
    public List<Student> getAll() {
        List students = super.getAll("from Student");
        return (List<Student>) students;
    }
}
