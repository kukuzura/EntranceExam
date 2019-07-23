package by.yurusova.entranceExam.services.interfaces;

import by.yurusova.entranceExam.entities.Speciality;

import java.util.List;

/**
 * Interface defines base speciality services operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
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

    /**
     * Updates speciality information in database.
     *
     * @param speciality speciality to be update.
     */
    void update(Speciality speciality);

    /**
     * Method saves speciality o database.
     *
     * @param speciality the speciality to be save.
     */
    void save(Speciality speciality);

    /**
     * Method delete speciality from database.
     *
     * @param speciality the speciality to be set.
     */
    void delete(Speciality speciality);
}
