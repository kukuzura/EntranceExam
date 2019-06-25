package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Teacher;

import java.util.List;

/**
 * Interface defines base teacher service operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
 *  @link http ://sam-solutions.com/
 *  @copyright 2019 SaM
 */
public interface TeacherService {
    /**
     * Save teacher to database.
     *
     * @param teacher the teacher.
     */
    void addTeacher(Teacher teacher);

    /**
     * Delete teacher.
     *
     * @param id the teacher.
     */
    void deleteTeacher(long id);

    /**
     * Update teacher.
     *
     * @param teacher the teacher.
     */
    void editTeacher(Teacher teacher);

    /**
     * Get list of teachers.
     *
     * @return list of teachers.
     */
    List<Teacher> getAll();

    /**
     * Get teacher by id.
     *
     * @param id the id.
     * @return the teacher with given id.
     */
    Teacher findById(long id);
}
