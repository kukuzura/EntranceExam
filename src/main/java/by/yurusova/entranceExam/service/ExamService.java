package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Exam;

import java.util.List;

/**
 * Interface defines base exam service operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface ExamService {

    /**
     * Method gets all exams from db.
     *
     * @return list of exams.
     */
    List<Exam> getAll();

    /**
     * Method saves exam.
     *
     * @param exam exam to be save.
     */
    void saveExam(Exam exam);

    /**
     * Method delete exam with given id.
     *
     * @param id the id.
     */
    void deleteExam(long id);

    /**
     * Method gets all exam with given speciality id.
     *
     * @param specialityID id of speciality.
     * @return list of exams.
     */
    List<Exam> findBySpeciality(long specialityID);
}
