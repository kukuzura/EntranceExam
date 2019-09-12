package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.AdminExamListController;
import by.yurusova.entranceExam.converters.ExamConverter;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.services.interfaces.ExamService;
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

import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test.xml", "classpath:test-database.xml"})
@Transactional
public class AdminExamListControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private AdminExamListController controller;

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamConverter examConverter;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Before
    public void beforeGet() {
        Exam exam = new Exam();
        examService.saveExam(exam);
    }

    @Test
    public void testGet() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/examListPage.jsp");
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("http://localhost:9090/admin/examList");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void beforeDelete() {
        Exam exam = new Exam();
        exam.setId(2);
        examService.saveExam(exam);
    }

    @Test
    public void testDelete() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/examDelete/2");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(examService.findByID(2));
    }

    @Test
    public void deleteEntityThatDontExist() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("http://localhost:9090/admin/examDelete/2");
        examService.deleteExam(2);
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    public void setController(AdminExamListController controller) {
        this.controller = controller;
    }

    public void setExamConverter(ExamConverter examConverter) {
        this.examConverter = examConverter;
    }
}
