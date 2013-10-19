package course.controller.events.edit;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import course.model.domain.categories.Category;
import course.model.domain.events.Event;

public class EventEditForm {

    private String       oldTitle;
    private String       newTitle;
    private String       date;
    private String       description;
    private Set<String> categories = new HashSet<String>();

    public EventEditForm() {

    }

    public EventEditForm(Event event) {
        this.oldTitle = event.getTitle();
        this.newTitle = event.getTitle();
        // 2013-09-29
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(event.getDate());
        this.description = event.getDescription();
        for (Category c : event.getCategories()) {
            this.categories.add(c.getName());
        }
    }

    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    public String getOldTitle() {
        return this.oldTitle;
    }
    
    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewTitle() {
        return this.newTitle;
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
