package by.yurusova.entranceExam.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class for speciality.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.speciality")
public class Speciality {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "speciality", cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Exam> exams;

    @Column(name = "entering_grade")
    private double enteringGrade;

    @PreRemove
    private void preRemove() {
        for (Exam exam : exams) {
            exam.setSpeciality(null);
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
}
