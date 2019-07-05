package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.entities.Speciality;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from SpecialityDTO to Speciality.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityReverseConverter implements Converter<SpecialityDTO, Speciality> {
    @Override
    public Speciality convert(final SpecialityDTO source) {
        return new Speciality(source.getId(), source.getName());
    }
}
