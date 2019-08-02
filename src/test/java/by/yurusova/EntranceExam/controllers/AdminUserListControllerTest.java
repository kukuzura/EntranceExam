package by.yurusova.EntranceExam.controllers;

import by.yurusova.entranceExam.controllers.UsersDisplayController;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.UserService;
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

import static junit.framework.TestCase.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test.xml", "classpath:test-database.xml"})
@Transactional
public class AdminUserListControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private UsersDisplayController controller;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Before
    public void beforeDelete() {
        User user = new User();
        user.setId(1);
        user.setPassword("");
        userService.addUser(user);
    }

    @Test
    public void testDelete() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("http://localhost:9090/admin/userDelete/1");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(userService.findById(1));

    }

    @Test
    public void testGet() {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher view = MockMvcResultMatchers.view()
                .name("/userList.jsp");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("http://localhost:9090/admin/userList");
        try {
            this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public void setController(UsersDisplayController controller) {
        this.controller = controller;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
