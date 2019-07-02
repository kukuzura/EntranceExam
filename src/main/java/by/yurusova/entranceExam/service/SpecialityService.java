package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Speciality;

import java.util.List;

/**
 * Interface defines base speciality service operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface SpecialityService {

    /**
     * Gets all specialities from db.
     *
     * @return list of specialities.
     */
    List<Speciality> getAll();

    /**
     * Gets speciality by id.
     *
     * @param id the id.
     * @return the speciality.
     */
    Speciality findById(long id);
}
