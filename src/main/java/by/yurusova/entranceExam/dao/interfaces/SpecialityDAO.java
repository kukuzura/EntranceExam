package by.yurusova.entranceExam.dao.interfaces;

import by.yurusova.entranceExam.entities.Speciality;

import java.util.List;

/**
 * Interface defines base operations that can be performed with speciality objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface SpecialityDAO {

    /**
     * Method gets speciality by id.
     *
     * @param id the speciality id.
     * @return speciality with given id.
     */
    Speciality findById(long id);

    /**
     * Method saves speciality to db.
     *
     * @param speciality speciality to be save.
     * @return
     */
    Long saveSpeciality(Speciality speciality);

    /**
     * Method delete speciality from db.
     *
     * @param speciality speciality to delete.
     */
    void delete(Speciality speciality);

    /**
     * Method update speciality in db.
     *
     * @param speciality speciality to be update.
     */
    void update(Speciality speciality);

    /**
     * Method gets all specialities from db.
     *
     * @return list of specialities.
     */
    List<Speciality> getAll();
}
