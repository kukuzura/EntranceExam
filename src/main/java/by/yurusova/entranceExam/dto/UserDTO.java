package by.yurusova.entranceExam.dto;

/**
 * DTO for User.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserDTO {

    private long id;

    private String login;

    private String password;

    /**
     * Constructor with parameters foe userDTO.
     *
     * @param id       id of new userDTO
     * @param login    login of new userDTO.
     * @param password password of new userDTO.
     */
    public UserDTO(final long id, final String login, final String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    /**
     * Constructor for userDTO.
     */
    public UserDTO() {
    }

    /**
     * Gets login.
     *
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login login o be set.
     */
    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password passwprd to be set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets user id.
     *
     * @return the id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id to be set.
     */
    public void setId(final long id) {
        this.id = id;
    }
}
