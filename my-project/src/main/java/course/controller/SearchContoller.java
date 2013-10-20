package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import course.controller.services.search.SearchService;

@Controller
public class SearchContoller {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchResult(@RequestParam(value = "query") String query,
            ModelMap model) {
        if (query.isEmpty())
            return "redirect:/welcome";
        model.put("result", searchService.search(query));
        return "search_result";
    }

}
