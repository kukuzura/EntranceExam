package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.GradeDAO;
import by.yurusova.entranceExam.entities.Grade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Class responsible for operations with grade table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class GradeDAOImpl extends AbstractBaseDAO implements GradeDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(GradeDAOImpl.class);

    @Override
    public List<Grade> findGradesByStudentId(final long studentId) {
        List grades = sessionFactory.getCurrentSession().createQuery(
                "SELECT grade FROM Grade grade WHERE grade.studbt_id=:student_id")
                .setParameter("student_id", studentId)
                .getResultList();
        return (List<Grade>) grades;
    }

    @Override
    public void saveGrade(final Grade grade) {
        super.save(grade);
    }

    @Override
    public void update(Grade grade) {
        super.update(grade);
    }

    @Override
    public List<Grade> getAll() {
        List grades = super.getAll("from Grade");
        return (List<Grade>) grades;
    }

    @Override
    public Grade getByStudentAndExam(long studentID, long examID) {
        Object grade = new Grade();
        try {
            grade = sessionFactory.getCurrentSession().createQuery("SELECT grade " +
                    " FROM Grade AS grade " +
                    " JOIN grade.exam AS exam " +
                    " JOIN grade.student as student " +
                    " WHERE exam.id=:examID AND student.id=:studentID\n ")
                    .setParameter("examID", examID)
                    .setParameter("studentID",studentID)
                    .getSingleResult();

        }
        catch (NoResultException ex) {
            LOGGER.error("No student found for exam");
        }
        finally {
            return (Grade)grade;
        }
    }
}
