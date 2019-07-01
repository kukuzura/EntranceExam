package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Exam;

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
public class ExamDAOImpl extends AbstractBaseDAO implements ExamDAO {
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
    public List<Exam> findBySpeciality(long specialityID) {
        List exams = null;
        try {
            exams = sessionFactory.getCurrentSession().createQuery(
                    "SELECT exam FROM Exam exam WHERE exam.speciality_id =: speciality_id")
                    .setParameter("speciality_id", specialityID)
                    .getResultList();
        }
        catch (NoResultException ex) {
        }
        finally {
            return (List<Exam>) exams;
        }
    }
}
