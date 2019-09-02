package kg.itservice.tvmaze.controller.api;

import kg.itservice.tvmaze.model.ShowCast;
import kg.itservice.tvmaze.service.TVMazeShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/show")
public class ShowControllerApi {

    private final TVMazeShowService showService;

    public ShowControllerApi(TVMazeShowService showService) {
        this.showService = showService;
    }

    @GetMapping("{showId}/cast")
    public List<ShowCast> getShowCast(
            @PathVariable Long showId
    ){
        return showService.getCastOrderByBirthday(showId);
    }
}
