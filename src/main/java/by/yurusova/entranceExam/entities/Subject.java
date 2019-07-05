package by.yurusova.entranceExam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entity class for subject.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entities
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
    private List<Exam> exams;

    /**
     * Constructor for Subject.
     */
    public Subject() {
    }

    /**
     * Constructor with parameters for Subject.
     *
     * @param id   id of new Subject.
     * @param name name of new Subject.
     */
    public Subject(final long id, final String name) {
        this.id = id;
        this.name = name;
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
     * Gets list of exams with current subject.
     *
     * @return the list of exams.
     */
    public List<Exam> getExams() {
        return exams;
    }

    /**
     * Sets list of exams.
     *
     * @param exams the list of exams.
     */
    public void setExams(final List<Exam> exams) {
        this.exams = exams;
    }
}
