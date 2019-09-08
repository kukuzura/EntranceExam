package by.yurusova.entranceExam.dao.interfaces;


import by.yurusova.entranceExam.entities.Teacher;

import java.util.List;

/**
 * Interface defines base operations that can be performed with teacher objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface TeacherDAO {
    /**
     * Get teacher  by id.
     *
     * @param id the teacher id.
     * @return the teacher.
     */
    Teacher findById(long id);

    /**
     * Saves teacher in db.
     *
     * @param teacher teacher object.
     * @return
     */
    Long saveTeacher(Teacher teacher);

    /**
     * Delete teacher from db.
     *
     * @param teacher the teacher object.
     */
    void delete(Teacher teacher);

    /**
     * Update teacher.
     *
     * @param teacher the teacherobject.
     */
    void update(Teacher teacher);

    /**
     * Get all teachers from db.
     *
     * @return list of teachers.
     */
    List<Teacher> getAll();

}
