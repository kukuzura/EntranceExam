package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.SpecialityConverter;
import by.yurusova.entranceExam.converters.SpecialityListConverter;
import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Facade for operations with specialities.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityOperationsFacade {

    private SpecialityService specialityService;

    private SpecialityConverter specialityConverter;

    private SpecialityListConverter specialityListConverter;

    /**
     * Method creates ModelAndVies for speciality list page,
     * converts it to list of specialityDTO and sets on modelAndView.
     *
     * @return speciality list page.
     */
    public ModelAndView createSpecialityList() {
        ModelAndView modelAndView = new ModelAndView("/adminSpecialityList.jsp");
        List<Speciality> specialityList = specialityService.getAll();
        modelAndView.addObject("specialityList", specialityListConverter.convertList(specialityList));
        return modelAndView;
    }

    /**
     * Method converts specialityDTO to speciality add speciality to database.
     *
     * @param specialityDTO fto to be convert.
     */
    public void addSpeciality(final SpecialityDTO specialityDTO) {
        Speciality speciality = specialityConverter.convertBack(specialityDTO);
        specialityService.save(speciality);
    }

    /**
     * Method delete speciality from database by id.
     *
     * @param id the id.
     */
    public void deleteSpeciality(final long id) {
        Speciality speciality = specialityService.findById(id);
        specialityService.delete(speciality);
    }

    /**
     * Sets speciality service.
     *
     * @param specialityService service to be set.
     */
    public void setSpecialityService(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    /**
     * ets speciality converter.
     *
     * @param specialityConverter converter to be set.
     */
    public void setSpecialityConverter(final SpecialityConverter specialityConverter) {
        this.specialityConverter = specialityConverter;
    }

    /**
     * Sets speciality list converter.
     *
     * @param specialityListConverter converter to be set.
     */
    public void setSpecialityListConverter(final SpecialityListConverter specialityListConverter) {
        this.specialityListConverter = specialityListConverter;
    }
}
