package by.yurusova.entranceExam.dto;

import java.util.List;

/**
 * DTO represents information about central tests results of students
 * and its total school grade for university entrance.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentTestsInfoDTO {

   List<SubjectGradeDTO> grades;

    public StudentTestsInfoDTO() {

    }

    public List<SubjectGradeDTO> getGrades() {
        return grades;
    }

    public void setGrades(List<SubjectGradeDTO> grades) {
        this.grades = grades;
    }
}
