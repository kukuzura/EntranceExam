package by.yurusova.entranceExam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "student")
public class Student implements Serializable {

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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    private List<Grade> grades;

    @Column(name = "grade")
    private int totalGrade;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    /**
     * Constructor for Student class.
     */
    public Student() {

    }

    /**
     * Constructor with parameters for class Student.
     *
     * @param passportID passport id of new student.
     * @param firstName  first name of new student.
     * @param lastName   last name id of new student.
     * @param patronymic patronymic of new student.
     */
    public Student(final String passportID, final String firstName, final String lastName, final String patronymic) {
        this.passportID = passportID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }


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

    /**
     * Gets student grades.
     *
     * @return list of grades.
     */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
     * Sets student grades.
     *
     * @param grades grades to be set.
     */
    public void setGrades(final List<Grade> grades) {
        this.grades = grades;
    }

    /**
     * Gets student total grade.
     *
     * @return total grade.
     */
    public int getTotalGrade() {
        return totalGrade;
    }

    /**
     * Sets student total grade.
     *
     * @param totalGrade grade to be set.
     */
    public void setTotalGrade(final int totalGrade) {
        this.totalGrade = totalGrade;
    }

    /**
     * Gets student status.
     *
     * @return student status.
     */
    public StudentStatus getStatus() {
        return status;
    }

    /**
     * Sets student status.
     *
     * @param status status to be set.
     */
    public void setStatus(final StudentStatus status) {
        this.status = status;
    }
}
