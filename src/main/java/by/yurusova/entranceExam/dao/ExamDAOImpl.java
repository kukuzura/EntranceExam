package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.entities.Exam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Class responsible for operations with exam table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamDAOImpl extends AbstractBaseDAO<Exam> implements ExamDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExamDAOImpl.class);

    @Override
    public Exam findById(final long id) {
        return super.findById(id, Exam.class);
    }

    @Override
    public void saveExam(final Exam exam) {
        super.save(exam);
    }

    @Override
    public void delete(final Exam exam) {
        super.delete(exam);
    }

    @Override
    public void update(final Exam exam) {
        super.update(exam);
    }

    @Override
    public List<Exam> getAll() {
        return super.getAll("from Exam", Exam.class);
    }

    @Override
    public List<Exam> findBySpeciality(final long specialityID) {
        List<Exam> exams = null;
        try {
            exams = sessionFactory.getCurrentSession().createQuery(
                    "SELECT exam " +
                            "FROM Exam AS exam " +
                            "JOIN exam.speciality AS speciality " +
                            "WHERE speciality.id =: speciality_id", Exam.class)
                    .setParameter("speciality_id", specialityID)
                    .getResultList();
        }
        catch (NoResultException ex) {
            LOGGER.error("No exams found for speciality");
        }
        return exams;
    }

    @Override
    public List<Exam> findByStudent(final long studentID) {
        List<Exam> exams = null;
        try {
            exams = sessionFactory.getCurrentSession().createQuery("SELECT exam " +
                    " FROM Exam AS exam " +
                    " JOIN exam.grades AS grade " +
                    " JOIN grade.student as student " +
                    " WHERE student.id=:studentID \n ", Exam.class)
                    .setParameter("studentID", studentID).getResultList();
        }
        catch (NoResultException ex) {
            LOGGER.error("No exams found for student");
        }
        return exams;

    }
}
