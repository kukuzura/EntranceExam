package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.entities.Speciality;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from Speciality to SpecialityDTO.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityConverter implements Converter<Speciality, SpecialityDTO> {

    @Override
    public SpecialityDTO convert(final Speciality source) {
        return new SpecialityDTO(source.getId(), source.getName());
    }
}
