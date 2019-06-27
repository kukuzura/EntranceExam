package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.SubjectDAO;
import by.yurusova.entranceExam.entity.Subject;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDAO;

    @Override
    public List<Subject> getAll() {
        List subjects = subjectDAO.getAll();
        return (List<Subject>) subjects;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }
}
