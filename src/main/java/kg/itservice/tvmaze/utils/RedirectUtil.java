package kg.itservice.tvmaze.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class RedirectUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(RedirectUtil.class);

    public static ModelAndView redirect(String path) {
        RedirectView view = new RedirectView();
        view.setUrl(path);
        view.setExposeModelAttributes(false);
        return new ModelAndView(view);
    }
}
