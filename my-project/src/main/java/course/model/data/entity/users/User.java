package course.model.data.entity.users;

import java.io.Serializable;
import course.model.data.entity.users.fields.Role;
import course.model.data.entity.users.fields.Language;
import course.model.data.entity.users.fields.Stile;
import course.model.data.entity.events.Event;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idUser;
    private String nickName;
    private String login;
    private String password;
    private String email;
    private Role role = Role.USER;
    private Language language = Language.RUSSIAN;
    private Stile stile = Stile.LIGTH;
    private int idAvatar = 0;
    private String shortDescription;
    private Set<Event> userEvents = new HashSet<Event>();

    public User() {
    }

    public User(String nickName, String login, String password, String email) {
        this.nickName = nickName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getIdAvatar() {
        return this.idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Set<Event> getUserEvents() {
        return this.userEvents;
    }

    public void setUserEvents(Set<Event> userEvents) {
        this.userEvents = userEvents;
    }

    @Override
    public String toString() {
        String result = "idUser: " + idUser + ", ";
        result += "nickName: " + nickName + ", ";
        result += "login: " + login + ", ";
        result += "password: " + password + ", ";
        result += "email: " + email + ", ";
        result += "role: " + role.name() + ", ";
        result += "language: " + language.name() + ", ";
        result += "stile: " + stile.name() + ", ";
        result += "idAvatar: " + idAvatar + ", ";
        result += "shortDescription: " + shortDescription + ", ";
        result += "userEvents: " + userEvents + ";";
        return result;
    }
}
