package by.yurusova.entranceExam.dto;

import java.io.Serializable;

/**
 * DTO for Teacher.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherDTO implements Serializable {

    private long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    /**
     * Constructor with parameters for class TeacherDTO.
     *
     * @param id         id of new user.
     * @param firstName  first name of new teacherDTO.
     * @param lastName   last name of new teacherDTO.
     * @param patronymic patronymic of new teacherDTO.
     */
    public TeacherDTO(final long id, final String firstName, final String lastName, final String patronymic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    /**
     * Constructor for class TeacherDTO.
     */
    public TeacherDTO() {
    }

    /**
     * Gets first name.
     *
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName first name to be set.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName last name to be set.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets patronymic.
     *
     * @return patronymic.
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets patronymic.
     *
     * @param patronymic patronymic to be set.
     */
    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Gets teacher id.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets teacher id.
     *
     * @param id id to be set.
     */
    public void setId(final long id) {
        this.id = id;
    }
}
