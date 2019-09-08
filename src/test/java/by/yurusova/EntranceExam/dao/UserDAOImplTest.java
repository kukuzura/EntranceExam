package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.UserDAO;
import by.yurusova.entranceExam.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
public class UserDAOImplTest {

    @Autowired
    private UserDAO userDAO;
    private Long id1;
    private Long id2;

    @Before
    public void before() {
        User user1 = new User();
        user1.setLogin("login1");
        user1.setPassword("password");
        id1 = userDAO.saveUser(user1);
        User user2 = new User();
        user2.setLogin("login2");
        user2.setPassword("password");
        id2 = userDAO.saveUser(user2);
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userDAO.getAll();
        assertEquals("check User has been created", 2, users.size());
    }

    @After
    public void after() {
        userDAO.delete(userDAO.findById(id1));
        List<User> users = userDAO.getAll();
        assertEquals("Should be only one", 1, users.size());
        userDAO.delete(userDAO.findById(id2));
        users = userDAO.getAll();
        assertEquals("Should be empty", 0, users.size());
    }

}