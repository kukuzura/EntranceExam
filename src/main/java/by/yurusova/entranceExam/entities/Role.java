package by.yurusova.entranceExam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entity class for role.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.entities
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private long id;

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
    public void setId(final long id) {
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
