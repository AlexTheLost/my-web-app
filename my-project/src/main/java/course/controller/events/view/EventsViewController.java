package course.controller.events.view;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import course.model.dao.categories.CategoriesDaoImpl;
import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.events.Event;
import course.model.domain.users.User;
import course.model.domain.users.fields.Role;
import course.model.domain.categories.Category;

@Controller
@RequestMapping(value = "event_page")
public class EventsViewController {

    List<Category> allCategories = new CategoriesDaoImpl().getAll();

    @RequestMapping(method = RequestMethod.GET)
    public String addEvent(
            @RequestParam(value = "eventTitle") String eventTitle,
            ModelMap model) {
        model.putAll(getOptionsForUser(eventTitle));
        model.put("event", getEvent(eventTitle));
        return "event_page";
    }

    private Event getEvent(String eventTitle) {
        EventDao eDao = new EventDaoImpl();
        System.out.println("eventTitle:" + eventTitle);
        Event event = eDao.findByTitleDep(eventTitle);
        return event;
    }
    private ModelMap getOptionsForUser(String eventTitle) {
        String userName = getCurrentUserName();
        ModelMap model = new ModelMap();
        if (!userName.equals("anonymousUser")) {
            boolean member = ifUserMemberEvent(userName, eventTitle);
            boolean authority = ifUserHaveAuthorities();
            if (member || authority) {
                model.put("modify", true);
            } else {
                model.put("modify", false);
            }
            if (member) {
                model.put("member", true);
            } else {
                model.put("member", false);
            }
        } else {
            model.put("modify", false);
            model.put("member", false);
        }
        return model;
    }

    private String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        return auth.getName();
    }

    private boolean ifUserMemberEvent(String userName, String eventTitle) {
        UserDao uDao = new UserDaoImpl();
        User user = uDao.findUserByNameDepEvents(userName);
        Set<Event> events = user.getEvents();
        if (ifUserHasEvent(events, eventTitle))
            return true;
        return false;
    }

    private boolean ifUserHasEvent(Set<Event> events, String eventTitle) {
        for (Event e : events) {
            if (e.getTitle().equals(eventTitle)) {
                return true;
            }
        }
        return false;
    }

    private boolean ifUserHaveAuthorities() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.getAuthority().equals(Role.ROLE_MANAGER.name())) {
                return true;
            } else if (ga.getAuthority().equals(Role.ROLE_ADMINISTRATOR.name())) {
                return true;
            }
        }
        return false;
    }
}
