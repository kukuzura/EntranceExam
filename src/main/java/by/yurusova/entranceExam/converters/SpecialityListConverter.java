package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.entities.Speciality;

import java.util.ArrayList;
import java.util.List;

/**
 * Two way converter from list of Speciality to list of SpecialityDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityListConverter implements ListTwoWayConverter<Speciality, SpecialityDTO> {

    private SpecialityConverter specialityConverter;

    @Override
    public List<SpecialityDTO> convertList(final List<Speciality> source) {
        List<SpecialityDTO> specialityDTOS = new ArrayList<>();
        for (Speciality speciality : source) {
            specialityDTOS.add(specialityConverter.convert(speciality));
        }
        return specialityDTOS;
    }

    @Override
    public List<Speciality> convertBackList(final List<SpecialityDTO> target) {
        List<Speciality> specialities = new ArrayList<>();
        for (SpecialityDTO specialityDTO : target) {
            specialities.add(specialityConverter.convertBack(specialityDTO));
        }
        return specialities;
    }

    /**
     * Sets speciality converter.
     *
     * @param specialityConverter converter to be set.
     */
    public void setSpecialityConverter(final SpecialityConverter specialityConverter) {
        this.specialityConverter = specialityConverter;
    }
}
