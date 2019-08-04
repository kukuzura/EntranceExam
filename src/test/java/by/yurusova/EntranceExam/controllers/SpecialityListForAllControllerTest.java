package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.SpecialityListForAllController;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
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
public class SpecialityListForAllControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private SpecialityListForAllController specialityListForAllController;

    @Autowired
    private SpecialityService specialityService;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(specialityListForAllController).build();
    }

    @Before
    public void before() {
        specialityService.save(new Speciality());
    }

    @Test
    public void testGetPage() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/specialityList.jsp");
        ResultMatcher list = MockMvcResultMatchers.model().attribute("specialityList", null);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/specialityList");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(view)
                    .andExpect(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSpecialityListForAllController(SpecialityListForAllController specialityListForAllController) {
        this.specialityListForAllController = specialityListForAllController;
    }

    public void setSpecialityService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }
}
