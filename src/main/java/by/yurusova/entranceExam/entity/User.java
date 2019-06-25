package by.yurusova.entranceExam.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class for user.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.user")
public class User {
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "examsdb.user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "user")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Teacher teacher;

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Get login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Get password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Sets login.
     *
     * @param login login to be set
     */
    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * Sets password.
     *
     * @param password password to be set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Set list of roles to curernt user.
     *
     * @param roles list of roles
     */
    public void setRoles(final List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Get roles of current user.
     *
     * @return list of roles
     */
    public List<Role> getRoles() {
        return roles;
    }
}
