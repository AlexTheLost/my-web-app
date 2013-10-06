package course.model.data.entity.events;

import java.io.Serializable;
import java.sql.Date;

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idEvent;
    private String name;
    private Date date = new Date(new java.util.Date().getTime());
    private String description;
    private Boolean topicality = true;
    private String location;

    public long getIdEvent() {
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
