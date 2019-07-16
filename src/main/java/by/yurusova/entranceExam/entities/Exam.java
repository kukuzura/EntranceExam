package by.yurusova.entranceExam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entity class for exam.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entities
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "exam")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST}, mappedBy = "exam")
    private List<Grade> grades;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    /**
     * Constructor for Exam.
     */
    public Exam() {
    }

    /**
     * Constructor with parameters for exam.
     *
     * @param id         id of new exam.
     * @param teacher    teacher of new exam.
     * @param subject    subject of new exam.
     * @param speciality speciality of new exam.
     */
    public Exam(final long id, final Teacher teacher, final Subject subject, final Speciality speciality) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.speciality = speciality;
    }

    /**
     * Gets exam id.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets exam id.
     *
     * @param id the id to be set.
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Gets teacher mapped with this exam.
     *
     * @return the teacher.
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Sets teacher mapped with this exam.
     *
     * @param teacher the teacher.
     */
    public void setTeacher(final Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Gets subject of exam.
     *
     * @return the subject.
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject rhw subject.
     */
    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    /**
     * Gets grades of current exam.
     *
     * @return list of grades.
     */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
     * Sets grades.
     *
     * @param grades list of grades.
     */
    public void setGrades(final List<Grade> grades) {
        this.grades = grades;
    }

    /**
     * Get speciality.
     *
     * @return the speciality.
     */
    public Speciality getSpeciality() {
        return speciality;
    }

    /**
     * Set speciality.
     *
     * @param speciality the speciality.
     */
    public void setSpeciality(final Speciality speciality) {
        this.speciality = speciality;
    }
}
