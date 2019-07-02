package by.yurusova.EntranceExam.dao;

import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entity.User;
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
    UserDAO userDAO;

    @Test
    public void testFindAllUsers() {
        List<User> users = userDAO.getAll();
        assertEquals("Check DB is empty first",0,users.size());
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userDAO.saveUser(user);
        users = userDAO.getAll();
        assertEquals("check User has been created", 1, users.size());
    }
}
