package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.ExamAddingController;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test.xml", "classpath:test-database.xml"})
@Transactional
public class ExamAddingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ExamAddingController controller;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetPage() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/addingExam.jsp");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/addExam");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
