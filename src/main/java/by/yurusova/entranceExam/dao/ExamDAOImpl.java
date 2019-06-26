package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Exam;

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
}
