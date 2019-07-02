package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.SpecialityDAO;
import by.yurusova.entranceExam.entity.Speciality;

import java.util.List;

/**
 * Class that perform base speciality services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityServiceImpl implements SpecialityService {

    private SpecialityDAO specialityDAO;

    @Override
    public List<Speciality> getAll() {
        return specialityDAO.getAll();
    }

    @Override
    public Speciality findById(final long id) {
        return specialityDAO.findById(id);
    }

    /**
     * Method sets specialityDAO.
     *
     * @param specialityDAO the specialityDAO.
     */
    public void setSpecialityDAO(final SpecialityDAO specialityDAO) {
        this.specialityDAO = specialityDAO;
    }
}
