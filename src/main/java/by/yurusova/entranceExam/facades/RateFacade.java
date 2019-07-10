package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.StudentConverterForRate;
import by.yurusova.entranceExam.converters.StudentReverseConverter;
import by.yurusova.entranceExam.dao.StudentForm;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.GradeService;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class RateFacade {
    private GradeService gradeService;

    private StudentService studentService;

    private ExamService examService;

    private StudentConverterForRate studentConverterForRate;

    private StudentReverseConverter reverseConverter;

    public ModelAndView showRatePage(final long examID) {
        ModelAndView modelAndView = new ModelAndView("/ratePage.jsp");
        modelAndView.addObject("examID", examID);
        modelAndView.addObject("student", new StudentDTO());
        List<Student> students = studentService.findByExamID(examID);
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(studentConverterForRate.convert(student));
        }
        StudentForm studentForm = new StudentForm();
        studentForm.setStudents(studentDTOS);
        modelAndView.addObject("studentForm", studentForm);
        return modelAndView;
    }

    public String rateStudents(ArrayList<StudentDTO> studentDTOS, long examID) {
        Exam exam = examService.findByID(examID);
        List<Student> students = new ArrayList<>();
        for (StudentDTO studentDTO : studentDTOS) {
            gradeService.updateByExamAndStudent(examID, studentDTO.getId(), studentDTO.getGrade());
        }
        return "/account/teacherPage.jsp";
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    public void setStudentConverterForRate(StudentConverterForRate studentConverterForRate) {
        this.studentConverterForRate = studentConverterForRate;
    }

    public void setReverseConverter(StudentReverseConverter reverseConverter) {
        this.reverseConverter = reverseConverter;
    }


}
