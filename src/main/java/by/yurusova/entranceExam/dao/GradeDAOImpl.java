package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Grade;

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
    public List<Grade> getAll() {
        List grades = super.getAll("from Grade");
        return (List<Grade>) grades;
    }
}
