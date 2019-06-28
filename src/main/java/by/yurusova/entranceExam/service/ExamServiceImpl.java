package by.yurusova.entranceExam.service;


import by.yurusova.entranceExam.dao.ExamDAO;
import by.yurusova.entranceExam.entity.Exam;

import java.util.List;

public class ExamServiceImpl implements ExamService {

    ExamDAO examDAO;

    @Override
    public List<Exam> getAll() {
        List exams = examDAO.getAll();
        return (List<Exam>) exams;
    }

    @Override
    public void saveExam(Exam exam) {
        examDAO.saveExam(exam);
    }

    public void setExamDAO(ExamDAO examDAO) {
        this.examDAO = examDAO;
    }
}
