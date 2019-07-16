package by.yurusova.entranceExam.entities;

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
import java.io.Serializable;
import java.util.List;

/**
 * Entity class for student.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entities
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<Exam> exams;

    /**
     * Constructor with parameters for Teacher.
     *
     * @param firstName  first name of new teacher.
     * @param lastName   last name of new teacher.
     * @param patronymic patronymic of new teacher.
     */
    public Teacher(final String firstName, final String lastName, final String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    /**
     * Constructor for teacher.
     */
    public Teacher() {
    }

    /**
     * Set first name.
     *
     * @param firstName first name to be set.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets first name.
     *
     * @return the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name.
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
     * @return the patronymic.
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
     * Gets id.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id to be set.
     */
    public void setId(final long id) {
        this.id = id;
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
     * Gets teachers exams.
     *
     * @return list of exams.
     */
    public List<Exam> getExams() {
        return exams;
    }

    /**
     * Sets teachers exams.
     *
     * @param exams list of exams to be set.
     */
    public void setExams(final List<Exam> exams) {
        this.exams = exams;
    }
}
