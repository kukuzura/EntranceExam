package by.yurusova.entranceExam.services;


import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.services.interfaces.ExamService;

import java.util.List;

/**
 * Class that perform base exam services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamServiceImpl implements ExamService {

    private ExamDAO examDAO;

    @Override
    public List<Exam> getAll() {
        List exams = examDAO.getAll();
        return (List<Exam>) exams;
    }

    @Override
    public void saveExam(final Exam exam) {
        examDAO.saveExam(exam);
    }

    @Override
    public void deleteExam(final long id) {
        Exam exam = new Exam();
        exam.setId(id);
        examDAO.delete(exam);
    }

    @Override
    public List<Exam> findBySpeciality(final long specialityID) {
        return null;
    }

    /**
     * Sets examDAO.
     *
     * @param examDAO examDAO to be set.
     */
    public void setExamDAO(final ExamDAO examDAO) {
        this.examDAO = examDAO;
    }
}
