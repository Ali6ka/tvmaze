package kg.itservice.tvmaze.client;

import kg.itservice.tvmaze.model.ShowCast;
import kg.itservice.tvmaze.model.ShowItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Component
public class TVMazeExchangeClient
{
    @Value("${tvmaze.show.search.uri}")
    private String showSearchUri;

    @Value("${tvmaze.show.cast.uri}")
    private String castUri;

    private final RestTemplate restTemplate;

    @Autowired
    public TVMazeExchangeClient(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public List<ShowItem> getShows(TVMazeRequestHolder requestHolder)
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(showSearchUri)
                .queryParam("q", requestHolder.getName());

        return  restTemplate.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ShowItem>>() {}).getBody();
    }

    public List<ShowCast> getShowCast(TVMazeRequestHolder requestHolder)
    {
        Map<String, String> pathParams = Map.of("id", requestHolder.getId().toString());
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(castUri);

        return  restTemplate.exchange(
                builder.buildAndExpand(pathParams).toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ShowCast>>() {}).getBody();
    }
}
