package course.controller.events.edit;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import course.model.domain.categories.Category;
import course.model.domain.events.Event;

public class EventEditForm {

    private String       title;
    private String       date;
    private String       description;
    private Set<String> categories = new HashSet<String>();

    public EventEditForm() {

    }

    public EventEditForm(Event event) {
        System.out.println("!!!!!!!!: " + event);
        this.title = event.getTitle();
        // 2013-09-29
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(event.getDate());
        this.description = event.getDescription();
        for (Category c : event.getCategories()) {
            this.categories.add(c.getName());
        }
    }

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

    public void setCategories(Set<String>  categories) {
        this.categories = categories;
    }

    public Set<String> getCategories() {
        return this.categories;
    }

}
