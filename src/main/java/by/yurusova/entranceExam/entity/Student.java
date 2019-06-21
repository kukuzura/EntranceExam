package by.yurusova.entranceExam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Entity class for student.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 *  @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.student")
public class Student {

    @Id
    @Column(name = "passport_id")
    private String passportID;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Set first name.
     *
     * @param firstName first name to be set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets passport id.
     *
     * @return the passport id
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Sets passport id.
     *
     * @param passportID passport id to be set
     */
    public void setPassportID(final String passportID) {
        this.passportID = passportID;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName last name to be set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets patronymic.
     *
     * @return the patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets patronymic.
     *
     * @param patronymic patronymic to be set
     */
    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Gets user mapped with this student.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user mapped with this student.
     *
     * @param user user to be set
     */
    public void setUser(final User user) {
        this.user = user;
    }
}
