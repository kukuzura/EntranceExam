package by.yurusova.entranceExam.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.DefaultNamingStrategy;

import javax.persistence.*;

@Entity
@Table(name = "examsdb.user")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 11, nullable = false, unique = true)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String password, String User) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
