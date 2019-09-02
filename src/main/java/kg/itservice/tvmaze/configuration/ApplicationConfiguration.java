package kg.itservice.tvmaze.configuration;

import kg.itservice.tvmaze.error.RestTemplateErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class ApplicationConfiguration
{
    @Bean(name = "restClient")
    public RestTemplate restClient() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.setMessageConverters(Arrays.asList(converter, new FormHttpMessageConverter()));
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());
        return restTemplate;
    }

}
