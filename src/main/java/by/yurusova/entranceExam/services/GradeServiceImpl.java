package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.GradeDAO;
import by.yurusova.entranceExam.entities.Grade;
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

    /**
     * Method sets gradedDAO.
     *
     * @param gradeDAO gradeDAO to be set.
     */
    public void setGradeDAO(final GradeDAO gradeDAO) {
        this.gradeDAO = gradeDAO;
    }
}
