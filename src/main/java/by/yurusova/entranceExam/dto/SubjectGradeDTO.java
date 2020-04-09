package by.yurusova.entranceExam.dto;

public class SubjectGradeDTO {

    private Long examId;

    private String subjectName;

    private Integer grade;

    public SubjectGradeDTO() {
    }

    public SubjectGradeDTO(Long examId, String subjectName, Integer grade) {
        this.examId = examId;
        this.subjectName = subjectName;
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public SubjectGradeDTO(String subjectName, Integer grade) {
        this.subjectName = subjectName;
        this.grade = grade;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }
}
