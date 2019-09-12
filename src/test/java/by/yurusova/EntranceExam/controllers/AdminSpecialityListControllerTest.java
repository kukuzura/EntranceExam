package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.AdminSpecialityListController;
import by.yurusova.entranceExam.converters.SpecialityListConverter;
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

import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test.xml", "classpath:test-database.xml"})
@Transactional
public class AdminSpecialityListControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private AdminSpecialityListController controller;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private SpecialityListConverter specialityListConverter;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Before
    public void beforeGet() {
        specialityService.save(new Speciality());
    }

    @Test
    public void testGet() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/adminSpecialityList.jsp");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/specialityList");
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
        Speciality speciality = new Speciality();
        specialityService.save(speciality);
    }

    @Test
    public void testDelete() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/specialityDelete/2");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(specialityService.findById(2));

    }


    public void setController(AdminSpecialityListController controller) {
        this.controller = controller;
    }

    public void setSpecialityService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    public void setSpecialityListConverter(SpecialityListConverter specialityListConverter) {
        this.specialityListConverter = specialityListConverter;
    }
}
