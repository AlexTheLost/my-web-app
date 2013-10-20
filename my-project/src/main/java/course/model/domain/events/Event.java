package course.model.domain.events;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import course.model.domain.categories.Category;
import course.model.domain.users.User;

public class Event implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3104381058522843275L;
    private int idEvent;
    private String title;
    private Date date = new Date(new java.util.Date().getTime());
    private String description;
    private Boolean topicality = true;
    private String location;
    private Set<Category> categories = new HashSet<Category>();
    private Set<User> users = new HashSet<User>();
    
    public Event() {
        
    }

    public Event(String title, java.util.Date date, String description) {
        this.title = title;
        this.date = new Date(date.getTime());
        this.description = description;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdEvent() {
        return this.idEvent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDate(java.util.Date date) {
        this.date = new Date(date.getTime());
    }

    public java.util.Date getDate() {
        return new java.util.Date(this.date.getTime());
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setTopicality(boolean topicality) {
        this.topicality = topicality;
    }

    public boolean getTopicality() {
        return this.topicality;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setUser(User user) {
        this.users.add(user);
    }
    
    public Set<User> getUsers() {
        return this.users;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!this.getClass().equals(obj.getClass()))
            return false;

        Event obj2 = (Event) obj;
        if (this.idEvent == obj2.getIdEvent() && this.title.equals(obj2)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (idEvent + title).hashCode();
        return tmp;
    }

    @Override
    public String toString() {
        String result = "id: " + idEvent + ", ";
        result += "title: " + title + ", ";
        result += "date: " + date.toString() + ", ";
        result += "description: " + description + ", ";
        result += "topicality: " + topicality + ", ";
        result += "location: " + location + ";";
        return result;
    }
}
