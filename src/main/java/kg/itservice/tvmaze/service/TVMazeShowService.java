package kg.itservice.tvmaze.service;

import kg.itservice.tvmaze.client.TVMazeRequestHolder;
import kg.itservice.tvmaze.client.TVMazeExchangeClient;
import kg.itservice.tvmaze.model.ShowCast;
import kg.itservice.tvmaze.model.ShowItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class TVMazeShowService
{
    private final TVMazeExchangeClient exchangeClient;

    @Autowired
    public TVMazeShowService(TVMazeExchangeClient exchangeClient)
    {
        this.exchangeClient = exchangeClient;
    }

    public List<ShowItem> searchForShows(String query)
    {
        return exchangeClient.getShows(TVMazeRequestHolder.of(query));
    }

    public List<ShowCast> getShowCast(Long showId){
        return exchangeClient.getShowCast(TVMazeRequestHolder.of(showId));
    }

    public List<ShowCast> getCastOrderByBirthday(Long showId)
    {
        List<ShowCast> cast = getShowCast(showId);
        if(Objects.nonNull(cast) && !cast.isEmpty()){
            cast.sort(Collections.reverseOrder());
        }

        return cast;
    }
}
