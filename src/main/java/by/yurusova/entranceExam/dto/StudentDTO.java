package by.yurusova.entranceExam.dto;

/**
 * DTO for Student.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class StudentDTO {

    private String passportID;

    private String firstName;

    private String lastName;

    private String patronymic;

    /**
     * Constructor with parameters for class StudentDTO.
     *
     * @param passportID passport id of new studentDTO.
     * @param firstName  first name of new studentDTO.
     * @param lastName   last name of new studentDTO.
     * @param patronymic patronymic of new studentDTO.
     */
    public StudentDTO(final String passportID, final String firstName, final String lastName, final String patronymic) {
        this.passportID = passportID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    /**
     * Constructor for class StudentDTO.
     */
    public StudentDTO() {
    }

    /**
     * Gets passport id.
     *
     * @return passport id.
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Sets passport id.
     *
     * @param passportID passport is to be set.
     */
    public void setPassportID(final String passportID) {
        this.passportID = passportID;
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
}
