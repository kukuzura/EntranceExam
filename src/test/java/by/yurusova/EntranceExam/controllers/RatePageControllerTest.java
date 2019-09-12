package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.RatePageController;
import by.yurusova.entranceExam.converters.StudentConverterForRate;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.dto.StudentForm;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Grade;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test.xml", "classpath:test-database.xml"})
@Transactional
public class RatePageControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private RatePageController controller;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamService examService;

    private StudentForm studentForm;

    @Autowired
    private StudentConverterForRate studentConverterForRate;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        studentForm = new StudentForm();
    }

    @Before
    public void beforeGetPage(){
        Student student = new Student();
        student.setPassportID("99999");
        Exam exam = new Exam();
        studentService.addStudent(student);
        examService.saveExam(exam);
        Grade grade = new Grade();
        grade.setExam(exam);
        grade.setStudent(student);
    }

    @Test
    public void getGradePage(){
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/ratePage.jsp");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/account/rate/1");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Before
    public void beforeGet(){
        List<Student> students = studentService.findByExamID(1);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(studentConverterForRate.convert(student));
        }
        studentForm.setStudents(studentDTOS);
    }
    @Test
    public void rateTest(){
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isFound();
        ResultMatcher redirect = MockMvcResultMatchers
                .redirectedUrl(" /account/teacherPage");
        ResultMatcher result = MockMvcResultMatchers
                .model()
                .attribute("studentForm", studentForm);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post("http://localhost:9090/account/rate/1")
                .flashAttr("studentForm",studentForm);
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(result)
                    .andExpect(redirect);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
