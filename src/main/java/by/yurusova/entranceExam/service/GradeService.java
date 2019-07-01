package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Grade;

import java.util.List;

public interface GradeService {

    void saveGrade(Grade grade);

    List<Grade> getAll(Grade grade);
}
