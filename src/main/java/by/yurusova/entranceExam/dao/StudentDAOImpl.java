package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.StudentDAO;
import by.yurusova.entranceExam.entities.Student;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
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
    public Student findById(final long id) {
        return (Student) super.findById(id, Student.class);
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

    @Transactional
    @Override
    public Student findByPassportID(final String passportID) {
        Object student = null;
        try {
            student = sessionFactory.getCurrentSession().createQuery(
                    "SELECT student FROM Student student WHERE student.passportID =: passport_id")
                    .setParameter("passport_id", passportID)
                    .getSingleResult();
        }
        catch (NoResultException ex) {
        }
        finally {
            return (Student) student;
        }
    }
}
