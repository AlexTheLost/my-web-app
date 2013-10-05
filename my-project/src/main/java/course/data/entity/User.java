package course.data.entity;

import java.io.Serializable;
import course.data.Role;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUser;
    private String nickName;
    private String login;
    private String password;
    private String email;
    private Role role = Role.USER;

    public User() {
    }

    public User(String nickName, String login, String password, String email) {
        this.nickName = nickName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String nickName, String login, String password, String email,
            Role role) {
        this.nickName = nickName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public String getnickName() {
        return this.nickName;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
