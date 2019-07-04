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

    private String login;

    private String password;

    /**
     * Constructor with parameters foe userDTO.
     *
     * @param login    login of new userDTO.
     * @param password password of new userDTO.
     */
    public UserDTO(final String login, final String password) {
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
}
