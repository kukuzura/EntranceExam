package by.yurusova.entranceExam.dto;

import java.io.Serializable;

/**
 * DTO for Subject.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectDTO implements Serializable {

    private long id;

    private String name;

    /**
     * Constructor for SubjectDTO.
     */
    public SubjectDTO() {
    }

    /**
     * Constructor with parameters for subjectDTO.
     *
     * @param id   id of new subjectDTO.
     * @param name name of new subjectDTO.
     */
    public SubjectDTO(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets subjectDTO id.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets subjectDTO name.
     *
     * @return subjectDTO name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets subject id.
     *
     * @param id id to be set.
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Sets subject name.
     * @param name name to be set.
     */
    public void setName(final String name) {
        this.name = name;
    }
}
