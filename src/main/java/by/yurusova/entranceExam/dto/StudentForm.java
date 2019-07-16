package by.yurusova.entranceExam.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that contains list of studentDTO.
 * Was created to pass list from jsp back to controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentForm implements Serializable {

    private ArrayList<StudentDTO> students;

    /**
     * Gets student list.
     *
     * @return list of studentDTO.
     */
    public ArrayList<StudentDTO> getStudents() {
        return students;
    }

    /**
     * Sets student list.
     *
     * @param students list to be set.
     */
    public void setStudents(final ArrayList<StudentDTO> students) {
        this.students = students;
    }


}
