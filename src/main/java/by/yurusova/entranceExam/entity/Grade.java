package by.yurusova.entranceExam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity class for grade.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.grade")
public class Grade implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "grade")
    private int grade;

    /**
     * Gets exam.
     *
     * @return the exam.
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * Sets exam.
     *
     * @param exam the exam.
     */
    public void setExam(final Exam exam) {
        this.exam = exam;
    }

    /**
     * Gets student.
     *
     * @return the student.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets student.
     *
     * @param student the student.
     */
    public void setStudent(final Student student) {
        this.student = student;
    }

    /**
     * Gets student grade foe exam.
     *
     * @return the grade.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets student grade for exam.
     *
     * @param grade the grade.
     */
    public void setGrade(final int grade) {
        this.grade = grade;
    }
}
