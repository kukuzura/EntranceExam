package by.yurusova.entranceExam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class for student.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "passport_id")
    private String passportID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    private List<Grade>grades;

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

    /**
     * Gets user id.
     *
     * @return the user id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets users id.
     *
     * @param id id to be set
     */
    public void setId(final long id) {
        this.id = id;
    }
}
