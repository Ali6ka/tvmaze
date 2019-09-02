package kg.itservice.tvmaze.controller.web;

import kg.itservice.tvmaze.model.ShowItem;
import kg.itservice.tvmaze.service.TVMazeShowService;
import kg.itservice.tvmaze.utils.RedirectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class SearchController
{
    private final static Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    private final TVMazeShowService showService;

    public SearchController(TVMazeShowService showService)
    {
        this.showService = showService;
    }

    @GetMapping
    public ModelAndView searchPage()
    {
        return new ModelAndView(String.format("%s/search-page", templates()));
    }


    @GetMapping("search")
    public ModelAndView search(
            @RequestParam(name = "query", required = false) String query
    ){
        ModelAndView modelAndView = new ModelAndView(String.format("%s/search-page", templates()))
                .addObject("query", query);
        List<ShowItem> shows = showService.searchForShows(query);

        if(Objects.nonNull(shows)) {
            modelAndView.addObject("shows", shows);
        }

        return modelAndView;
    }

    private @NotNull String templates() {
        return "/search";
    }
}
