package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.interfaces.GradeDAO;
import by.yurusova.entranceExam.entities.Grade;
import by.yurusova.entranceExam.services.interfaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Class that perform base grade services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDAO gradeDAO;

    @Override
    public void saveGrade(final Grade grade) {
        gradeDAO.saveGrade(grade);
    }

    @Override
    public List<Grade> getAll() {
        return gradeDAO.getAll();
    }

    @Override
    public void updateByExamAndStudent(final long examID, final long studentID, final int grade) {
        Grade gradeObj = gradeDAO.getByStudentAndExam(studentID, examID);
        gradeObj.setGrade(grade);
        gradeDAO.update(gradeObj);
    }

    @Override
    public int findByExamAndStudent(final long examID, final long studentID) {
        return gradeDAO.getByStudentAndExam(studentID, examID).getGrade();
    }

    /**
     * Method sets gradedDAO.
     *
     * @param gradeDAO gradeDAO to be set.
     */
    public void setGradeDAO(final GradeDAO gradeDAO) {
        this.gradeDAO = gradeDAO;
    }
}
