package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Grade;

import java.util.List;

public interface GradeDAO {

    List<Grade> findGradesByStudentId(long studentId);

    void saveGrade(Grade grade);

    List<Grade> getAll();
}
