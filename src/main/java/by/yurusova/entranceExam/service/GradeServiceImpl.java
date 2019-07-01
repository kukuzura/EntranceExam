package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.GradeDAO;
import by.yurusova.entranceExam.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeDAO gradeDAO;


    @Override
    public void saveGrade(Grade grade) {
        gradeDAO.saveGrade(grade);
    }

    @Override
    public List<Grade> getAll(Grade grade) {
        return gradeDAO.getAll();
    }

    public void setGradeDAO(GradeDAO gradeDAO) {
        this.gradeDAO = gradeDAO;
    }
}
