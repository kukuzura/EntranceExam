package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entities.Speciality;

import java.util.List;

/**
 * Class responsible for operations with speciality table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityDAOImpl extends AbstractBaseDAO implements SpecialityDAO {

    @Override
    public Speciality findById(final long id) {
        return (Speciality) super.findById(id, Speciality.class);
    }

    @Override
    public void saveSpeciality(final Speciality speciality) {
        super.save(speciality);
    }

    @Override
    public void delete(final Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void update(final Speciality speciality) {
        super.update(speciality);
    }

    @Override
    public List<Speciality> getAll() {
        List specialities = super.getAll("from Speciality");
        return (List<Speciality>) specialities;
    }
}
