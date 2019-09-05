package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.UserDAO;
import by.yurusova.entranceExam.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-database.xml"})
@Transactional
@Rollback
public class UserDAOImplTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void testFindAllUsers() {
        List<User> users = userDAO.getAll();
        assertEquals("check User has been created", 1, users.size());
    }

    @Before
    public void before() {
        User user1 = new User();
        user1.setLogin("login");
        user1.setPassword("password");
        userDAO.saveUser(user1);
        User user2 = new User();
        user2.setLogin("login");
        user2.setPassword("password");
        userDAO.saveUser(user2);
    }


    @Test
    public void deleteUser() {
        userDAO.delete(userDAO.findById(1));
        List<User> users = userDAO.getAll();
        assertEquals("", 0, users.size());
    }

}