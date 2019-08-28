package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.AdminSubjectListController;
import by.yurusova.entranceExam.converters.SubjectListConverter;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.services.interfaces.SubjectService;
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
public class AdminSubjectListControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private AdminSubjectListController controller;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectListConverter subjectListConverter;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Before
    public void beforeGet() {
        subjectService.save(new Subject());
    }

    @Test
    public void testGet() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/adminSubjectList.jsp");
        ResultMatcher result = MockMvcResultMatchers
                .model()
                .attribute("subjectList", subjectListConverter.convertList(subjectService.getAll()));

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/subjectList");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(view)
                    .andExpect(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void beforeDelete() {
        Subject subject = new Subject();
        subject.setId(1);
        subjectService.save(subject);
    }

    @Test
    public void testDelete() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/subjectDelete/1");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(subjectService.findById(1));

    }


    public void setController(AdminSubjectListController controller) {
        this.controller = controller;
    }

    public void setSubjectListConverter(SubjectListConverter subjectListConverter) {
        this.subjectListConverter = subjectListConverter;
    }
}
