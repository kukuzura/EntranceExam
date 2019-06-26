package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Grade;

import java.util.List;

public class GradeDAOImpl extends AbstractBaseDAO implements GradeDAO  {

    @Override
    public List<Grade> findGradesByStudentId(long studentId) {
        List grades = sessionFactory.getCurrentSession().createQuery(
                "SELECT grade FROM Grade grade WHERE grade.studbt_id=:student_id")
                .setParameter("student_id",studentId)
                .getResultList();
        return (List<Grade>) grades;
    }

    @Override
    public void saveGrade(Grade grade) {
        super.save(grade);
    }

    @Override
    public List<Grade> getAll() {
        List grades=super.getAll("from Grade");
        return (List<Grade>)grades;
    }
}
