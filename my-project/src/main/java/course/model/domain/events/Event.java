package course.model.domain.events;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import course.model.domain.categories.Category;

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idEvent;
    private String name;
    private Date date = new Date(new java.util.Date().getTime());
    private String description;
    private Boolean topicality = true;
    private String location;
    private Set<Category> categories = new HashSet<Category>();

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdEvent() {
        return this.idEvent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!this.getClass().equals(obj.getClass()))
            return false;

        Event obj2 = (Event) obj;
        if (this.idEvent == obj2.getIdEvent() && this.name.equals(obj2)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = (idEvent + name).hashCode();
        return tmp;
    }

    @Override
    public String toString() {
        String result = "id: " + idEvent + ", ";
        result += "name: " + name + ", ";
        result += "date: " + date.toString() + ", ";
        result += "description: " + description + ", ";
        result += "topicality: " + topicality + ", ";
        result += "location: " + location + ";";
        return result;
    }
}
