package by.yurusova.entranceExam.dao;


import by.yurusova.entranceExam.entities.Subject;

import java.util.List;

/**
 * Interface defines base operations that can be performed with subject objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface SubjectDAO {

    /**
     * Gets subject by id.
     *
     * @param id subject id.
     * @return subject with given id.
     */
    Subject findById(long id);

    /**
     * Method saves subject to db.
     *
     * @param subject subject to be save.
     */
    void saveSubject(Subject subject);

    /**
     * Method gets all subjects from db.
     *
     * @return list of subjects.
     */
    List<Subject> getAll();

    /**
     * Method delete subject from db.
     *
     * @param subject subject to be deleted.
     */
    void delete(Subject subject);

}
