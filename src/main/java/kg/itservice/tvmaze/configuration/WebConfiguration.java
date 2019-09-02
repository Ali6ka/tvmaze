package kg.itservice.tvmaze.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer
{
    private LocaleChangeInterceptor localeChangeInterceptor;

    @Autowired
    public WebConfiguration(
            LocaleChangeInterceptor localeChangeInterceptor
    ) {
        this.localeChangeInterceptor = localeChangeInterceptor;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/assets/favicon.ico");
        registry
                .addResourceHandler("/robots.txt")
                .addResourceLocations("classpath:/assets/robots.txt");
        registry
                .addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS");
    }

}