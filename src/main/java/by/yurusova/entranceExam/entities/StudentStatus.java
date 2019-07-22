package by.yurusova.entranceExam.entities;

/**
 * Enum for student status.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entities
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public enum StudentStatus {
    /**
     * Student that just only register.
     */
    NEW_STUDENT,
    /**
     * Student that start passing exams.
     */
    PASS_EXAMS,
    /**
     * Student that have enough total grade to enter specialty.
     */
    ENTER,
    /**
     * Student that haven't enough total grade.
     */
    DID_NOT_ENTER
}
