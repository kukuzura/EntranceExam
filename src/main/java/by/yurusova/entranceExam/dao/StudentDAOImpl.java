package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.StudentDAO;
import by.yurusova.entranceExam.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(SpecialityDAOImpl.class);

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
        return super.getAll("from Student");
    }

    @Transactional
    @Override
    public Student findByPassportID(final String passportID) {
        Student student = null;
        try {
            student = sessionFactory.getCurrentSession().createQuery(
                    "SELECT student FROM Student student WHERE student.passportID =: passport_id", Student.class)
                    .setParameter("passport_id", passportID)
                    .getSingleResult();
        }
        catch (NoResultException ex) {
            LOGGER.error("No student found ");
        }
        return student;
    }

    @Override
    public List<Student> findByExamID(final long examID) {
        List<Student> students = null;
        try {
            students = sessionFactory.getCurrentSession().createQuery("SELECT student " +
                    " FROM Student AS student " +
                    " JOIN student.grades AS grade " +
                    " JOIN grade.exam as exam " +
                    " WHERE exam.id=:examID \n ", Student.class)
                    .setParameter("examID", examID).getResultList();
        }
        catch (NoResultException ex) {
            LOGGER.error("No student found for exam");
        }
        return students;
    }
}
