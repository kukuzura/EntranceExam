package by.yurusova.entranceExam.services;


import by.yurusova.entranceExam.dao.interfaces.ExamDAO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import org.springframework.transaction.annotation.Transactional;

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
        return examDAO.getAll();
    }

    @Override
    public void update(final Exam exam) {
        examDAO.update(exam);
    }

    @Override
    public void saveExam(final Exam exam) {
        examDAO.saveExam(exam);
    }

    @Override
    @Transactional
    public void deleteExam(final long id) {
        Exam exam = examDAO.findById(id);
        if (exam != null) {
            examDAO.delete(exam);
        }
    }

    @Override
    public List<Exam> findBySpeciality(final long specialityID) {
        return examDAO.findBySpeciality(specialityID);
    }

    @Override
    public List<Exam> findByStudent(final long studentID) {
        return examDAO.findByStudent(studentID);
    }

    @Override
    public Exam findByID(final long id) {
        return examDAO.findById(id);
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
