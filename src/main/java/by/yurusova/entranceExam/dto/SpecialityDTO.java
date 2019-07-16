package by.yurusova.entranceExam.dto;

import java.io.Serializable;

/**
 * DTO for Speciality.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SpecialityDTO implements Serializable {

    private long id;

    private String name;

    /**
     * Constructor for SpecialityDTO.
     */
    public SpecialityDTO() {
    }

    /**
     * Constructor with parameters for SpecialityDTO.
     *
     * @param id   if of new specialityDTO.
     * @param name name of new specialityDTO.
     */
    public SpecialityDTO(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets specialityDTO id.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets name of subjectDTO.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }
}
