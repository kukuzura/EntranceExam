package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.entities.Exam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Class responsible for operations with exam table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamDAOImpl extends AbstractBaseDAO implements ExamDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExamDAOImpl.class);

    @Override
    public Exam findById(final long id) {
        return (Exam) super.findById(id, Exam.class);
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
        List exams = super.getAll("from Exam");
        return (List<Exam>) exams;
    }

    @Override
    public List<Exam> findBySpeciality(final long specialityID) {
        List exams = null;
        try {
            exams = sessionFactory.getCurrentSession().createQuery(
                    "SELECT exam " +
                            "FROM Exam AS exam " +
                            "JOIN exam.speciality AS speciality " +
                            "WHERE speciality.id =: speciality_id")
                    .setParameter("speciality_id", specialityID)
                    .getResultList();
        } catch (NoResultException ex) {
            LOGGER.error("No exams found for speciality");
        } finally {
            return (List<Exam>) exams;
        }
    }

    @Override
    public List<Exam> findByStudent(final long studentID) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT exam " +
                "                           FROM Exam AS exam " +
                "                            JOIN exam.grades AS grade " +
                "                            JOIN grade.student as student " +
                "                            WHERE student.id=:studentID \n ");
        List exams = query.setParameter("studentID", studentID).getResultList();
        return (List<Exam>) exams;

    }
}
