package course.controller.user.events;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.events.Event;
import course.model.domain.users.User;

@Controller
public class UserEventsController {
    @RequestMapping(value = "/user/user_events", method = RequestMethod.GET)
    public String printEvents(ModelMap model) {
        model.put("titles", getEventsTitleCurrentUser());
        return "user_events";
    }

    private Set<String> getEventsTitleCurrentUser() {
        Set<String> titles = new HashSet<String>();
        for (Event e : getCurrentUser().getEvents()) {
            titles.add(e.getTitle());
        }
        return titles;
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        UserDao uDao = new UserDaoImpl();
        User user = uDao.findUserByNameDepEvents(userName);
        return user;
    }

}