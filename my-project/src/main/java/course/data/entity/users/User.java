package course.data.entity.users;

import java.io.Serializable;
import course.data.entity.users.Role;
import course.data.entity.users.Language;
import course.data.entity.users.Stile;

class BeyondMaximumLength extends Exception {
}

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUser;
    private String nickName;
    private String login;
    private String password;
    private String email;
    private Role role = Role.USER;
    private Language language = Language.RUSSIAN;
    private Stile stile = Stile.LIGTH;
    private Long idAvatar = 0L;
    private String shortDescription;
    private final int MAX_LEN_SHORT_DESCRIPTION = 200;

    public User() {
    }

    public User(String nickName, String login, String password, String email) {
        this.nickName = nickName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
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

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Stile getStile() {
        return this.stile;
    }

    public void setStile(Stile stile) {
        this.stile = stile;
    }

    public Long getIdAvatar() {
        return this.idAvatar;
    }

    public void setIdAvatar(Long idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription)
            throws BeyondMaximumLength {
        if (shortDescription.length() > MAX_LEN_SHORT_DESCRIPTION)
            throw new BeyondMaximumLength();
        this.shortDescription = shortDescription;
    }
}
