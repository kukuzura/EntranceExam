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

    @Override
    public void deleteExam(long id) {
        Exam exam = new Exam();
        exam.setId(id);
        examDAO.delete(exam);
    }

    @Override
    public List<Exam> findBySpeciality(long specialityID) {
        return null;
    }

    public void setExamDAO(ExamDAO examDAO) {
        this.examDAO = examDAO;
    }
}
