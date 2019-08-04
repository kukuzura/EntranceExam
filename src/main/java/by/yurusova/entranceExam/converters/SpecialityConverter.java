package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.entities.Speciality;

/**
 * Two way converter from Speciality to SpecialityDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityConverter implements TwoWayConverter<Speciality, SpecialityDTO> {

    @Override
    public SpecialityDTO convert(final Speciality source) {
        if (source != null) {
            return new SpecialityDTO(source.getId(), source.getName());
        }
        else {
            return null;
        }
    }

    @Override
    public Speciality convertBack(final SpecialityDTO target) {
        return new Speciality(target.getId(), target.getName());
    }
}
