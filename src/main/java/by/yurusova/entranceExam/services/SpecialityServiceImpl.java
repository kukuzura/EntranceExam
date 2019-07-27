package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.interfaces.SpecialityDAO;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that perform base speciality services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
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

    @Override
    public void update(final Speciality speciality) {
        specialityDAO.update(speciality);
    }

    @Override
    public void save(final Speciality speciality) {
        specialityDAO.saveSpeciality(speciality);
    }

    @Override
    public void delete(final Speciality speciality) {
        specialityDAO.delete(speciality);
    }

    @Override
    public List<Speciality> getAllWithExamsAmount(final int examsAmount) {
        List<Speciality> specialities = specialityDAO.getAll();
        List<Speciality> removed = new ArrayList<>();
        for (Speciality speciality : specialities) {
            if (speciality.getExams().size() != examsAmount) {
                removed.add(speciality);
            }
        }
        specialities.removeAll(removed);
        return specialities;
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
