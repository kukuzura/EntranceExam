package by.yurusova.entranceExam.dto;

import java.io.Serializable;

/**
 * DTO for Exam.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamDTO implements Serializable {

    private long id;

    private TeacherDTO teacher;

    private SubjectDTO subject;

    private SpecialityDTO specialityDTO;

    /**
     * Constructor with parameters for ExamDTO.
     *
     * @param id            id of new ExamDTO.
     * @param teacher       teacher of new ExamDTO.
     * @param subject       subject of new ExamDTO.
     * @param specialityDTO speciality of new ExamDTO.
     */
    public ExamDTO(final long id, final TeacherDTO teacher, final SubjectDTO subject, final SpecialityDTO specialityDTO) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.specialityDTO = specialityDTO;
    }

    /**
     * Constructor for ExamDTO.
     */
    public ExamDTO() {

    }

    /**
     * Gets id of teacherDTO.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets teacherDTO.
     *
     * @return the teacherDTO.
     */
    public TeacherDTO getTeacher() {
        return teacher;
    }

    /**
     * Gets subjectDTO.
     *
     * @return the subjectDTO.
     */
    public SubjectDTO getSubject() {
        return subject;
    }

    /**
     * Gets specilaityDTO.
     *
     * @return the specialityDTO.
     */
    public SpecialityDTO getSpeciality() {
        return specialityDTO;
    }
}


