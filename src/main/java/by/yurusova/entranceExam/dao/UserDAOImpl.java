package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.hibernate.SessionFactory;

import java.util.List;


public class UserDAOImpl extends AbstractBaseDAO  implements UserDAO
{
    @Override
    public User findById(long id) {
        User user = (User)super.findById(id,User.class);
        return user;
    }


    @Override
    public void saveUser(User user) {
       super.save(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public void update(User user) {
        super.update(user);
    }


    @Override
    public List<User> getAll() {
        List users = super.getAll("from User");
        return (List<User>)users;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
