package course.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.domain.users.User;
import course.model.domain.events.Event;

@Controller
public class WelcomeController {

    private List<Event> allEvents   = null;
    private final int   eventOnPage = 5;
    private final int   first       = 0;
    private int         max         = 0;

    WelcomeController() {
        allEvents = getAllEventsOrderByData();
        max = allEvents.size();
    }

    private String hidePrev = "hidePrev";
    private String hideNext = "hideNext";
    private String hideNone = "hideNone";

    @RequestMapping(value = { "/", "welcome" }, method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        if (!model.containsAttribute("events")) {
            int end = getEndIndex(first);
            List<Event> events = allEvents.subList(first, end);
            model.put("events", events);
            model.put("end", end);
            model.put("hide", hidePrev);
        }
        return "welcome";
    }

    private final String prev = "prev";
    private final String next = "next";

    @RequestMapping(value = { "/", "welcome" }, method = RequestMethod.POST)
    public String eventsViewer(@RequestParam("route") String route,
            @RequestParam("end") int index, ModelMap model,
            final RedirectAttributes redirectAttributes) {
        if (route.equals(prev)) {
            int start = getStartIndex(index);
            int end = getEndIndex(start);
            List<Event> events = allEvents.subList(start, end);
            redirectAttributes.addFlashAttribute("events", events);
            redirectAttributes.addFlashAttribute("end", end);
            if (start == 0) {
                redirectAttributes.addFlashAttribute("hide", hidePrev);
            } else {
                redirectAttributes.addFlashAttribute("hide", hideNone);
            }
        } else if (route.equals(next)) {
            int end = getEndIndex(index);
            List<Event> events = allEvents.subList(index, end);
            redirectAttributes.addFlashAttribute("events", events);
            redirectAttributes.addFlashAttribute("end", end);
            if (end > (max + 1 - eventOnPage)) {
                redirectAttributes.addFlashAttribute("hide", hideNext);
            } else {
                redirectAttributes.addFlashAttribute("hide", hideNone);
            }
        }
        return "redirect:welcome";
    }

    private int getEndIndex(int index) {
        int end = index + eventOnPage;
        if (end > max)
            end = max;
        return end;
    }

    private int getStartIndex(int index) {
        // to normalize end index:
        int phantomMax = max + 1;
        if (index > (phantomMax - eventOnPage))
            index = phantomMax;
        int start = index - (2 * eventOnPage);
        if (start < 0)
            start = 0;
        return start;
    }

    private List<Event> getAllEventsOrderByData() {
        List<Event> events = null;
        EventDao eDao = new EventDaoImpl();
        events = eDao.getAllOrderByDate();
        return events;
    }
}
