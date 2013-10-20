package course.controller.user.become_member_event;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.events.Event;
import course.model.domain.users.User;

@Controller
public class BecomeMemberEventContoller {

    @RequestMapping(value = "/user/event_become_member", method = RequestMethod.GET)
    public String addUserToEvent(
            @RequestParam(value = "eventTitle") String eventTitle,
            final RedirectAttributes redirectAttributes) {
        addToEvent(eventTitle);
        redirectAttributes.addAttribute("eventTitle", eventTitle);
        return "redirect:/event_page";
    }

    private void addToEvent(String eventTitle) {
        Event event = getEvent(eventTitle);
        UserDao uDao = new UserDaoImpl();
        User user = uDao.findByNameNoLazy(getCurrentUserName());
        Set<Event> events = user.getEvents();
        events.add(event);
        user.setEvents(events);
        System.out.println("User: " + user);
        System.out.println("Event: " + event);
        uDao.update(user);
    }

    private Event getEvent(String eventTitle) {
        EventDao eDao = new EventDaoImpl();
        Event event = eDao.findByTitle(eventTitle);
        return event;
    }

    private String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();

        return userName;
    }
}
