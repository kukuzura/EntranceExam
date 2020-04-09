package by.yurusova.entranceExam.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entity class for speciality.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entities
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "speciality")
public class Speciality implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "speciality")
    private List<Exam> exams;

    @Column(name = "entering_grade")
    private double enteringGrade;

    @Column(name = "is_test")
    private boolean isTest;

    @Column(name = "is_entrance_finished")
    private boolean isEntranceFinished;

    /**
     * Constructor for Speciality.
     */
    public Speciality() {
    }

    /**
     * Constructor with parameters for Speciality.
     *
     * @param id   id of new Speciality.
     * @param name name of new Speciality.
     */
    public Speciality(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Speciality(final long id, final String name, final boolean isTest, final boolean isEntranceFinished) {
        this.id = id;
        this.name = name;
        this.isTest = isTest;
        this.isEntranceFinished = isEntranceFinished;
    }


    public Speciality(List<Exam> exams, double enteringGrade, boolean isTest) {
        this.exams = exams;
        this.enteringGrade = enteringGrade;
        this.isTest = isTest;
    }

    /**
     * Method sets speciality id as null for all exams of current speciality, if speciality was remove.
     */
    @PreRemove
    private void preRemove() {
        if (exams != null) {
            for (Exam exam : exams) {
                exam.setSpeciality(null);
            }
        }
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
     * Gets name.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name name to be set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets exams mapped with current speciality.
     *
     * @return list of exams.
     */
    @Transactional
    public List<Exam> getExams() {
        return exams;
    }

    /**
     * Sets exams.
     *
     * @param exams list od exams.
     */
    public void setExams(final List<Exam> exams) {
        this.exams = exams;
    }

    /**
     * Method entering grade to specialty.
     *
     * @return entering grade.
     */
    public double getEnteringGrade() {
        return enteringGrade;
    }

    /**
     * Method sets entering grade.
     *
     * @param enteringGrade grade to be set.
     */
    public void setEnteringGrade(final double enteringGrade) {
        this.enteringGrade = enteringGrade;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }

    public boolean isEntranceFinished() {
        return isEntranceFinished;
    }

    public void setEntranceFinished(boolean entranceFinished) {
        isEntranceFinished = entranceFinished;
    }
}
