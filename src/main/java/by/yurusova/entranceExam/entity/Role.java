package by.yurusova.entranceExam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class for role.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "examsdb.role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    /**
     * Gets role id.
     *
     * @return role id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets role id.
     *
     * @param id role id to be set.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets role name.
     *
     * @return the role name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets role name.
     *
     * @param name role name to be set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get list of users with current role.
     *
     * @return list of users.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Set user to current role.
     *
     * @param users users to be set.
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }
}
