package by.yurusova.entranceExam.services.security;


import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entities.Role;
import by.yurusova.entranceExam.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Custom UserDetailsService implementation.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services.security
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDAO userDAO;
    /**
     * Method returns spring user object with information of user loaded from db.
     *
     * @param username login of user from db.
     * @return spring user object.
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) {
        User user = userDAO.findByLogin(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }

    /**
     * Set userDAO.
     *
     * @param userDAO userDAO to be set.
     */
    public void setUserDAO(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
