package course.controller.events.create;

import java.util.List;

public class EventForm {

    private String       title;
    private String       date;
    private String       description;
    private List<String> categories;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return this.categories;
    }
}
