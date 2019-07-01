package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> getAll();

    void saveExam(Exam exam);

    void deleteExam(long id);

    List<Exam> findBySpeciality(long specialityID);
}
