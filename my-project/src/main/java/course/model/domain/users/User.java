package course.model.domain.users;

import java.io.Serializable;

import course.model.domain.avatars.Avatar;
import course.model.domain.categories.Category;
import course.model.domain.events.Event;
import course.model.domain.users.fields.Language;
import course.model.domain.users.fields.Role;
import course.model.domain.users.fields.Stile;

import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

    private static final long serialVersionUID = -7330260955093711250L;
    private int idUser;
    private String name;
    private String email;
    private String password;
    private Role role = Role.ROLE_USER;
    private Language language = Language.RUSSIAN;
    private Stile stile = Stile.DARCK;
    private int idAvatar = 0;
    private String shortDescription;
    private Set<Event> events = new HashSet<Event>();
    private Set<Category> categories = new HashSet<Category>();
    private Set<Avatar> avatars = new HashSet<Avatar>();

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Event> getEvents() {
        return this.events;
    }

    public void setEvents(Set<Event> userEvents) {
        this.events = userEvents;
    }

    public void setEvent(Event userEvent) {
        this.events.add(userEvent);
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setAvatars(Set<Avatar> avatars) {
        this.avatars = avatars;
    }

    public Set<Avatar> getAvatars() {
        return this.avatars;
    }

    public String toString() {
        String separator = ", ";
        String end = ";";
        String result = "";
        result += "IdUser: " + getIdUser();
        result += separator;
        result += "Name: " + getName();
        result += separator;
        result += "Email: " + getEmail();
        result += separator;
        result += "Password: " + getPassword();
        result += separator;
        result += "Language: " + getLanguage();
        result += separator;
        result += "Stile: " + getStile();
        result += separator;
        result += "idAvatar: " + getIdAvatar();
        result += separator;
        result += "shortDescription: " + getShortDescription();
        result += end;
        return result;
    }

}
