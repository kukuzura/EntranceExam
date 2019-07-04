package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.entities.Subject;

import java.util.List;

/**
 * Interface defines base subject services operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface SubjectService {

    /**
     * Method gets all subjects.
     *
     * @return lit of subject.
     */
    List<Subject> getAll();

    /**
     * Method gets speciality by id.
     *
     * @param id the id.
     * @return the speciality.
     */
    Subject findById(long id);
}
