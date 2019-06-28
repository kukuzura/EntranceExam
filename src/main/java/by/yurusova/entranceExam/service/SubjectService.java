package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAll();

    Subject findById(long id);
}
