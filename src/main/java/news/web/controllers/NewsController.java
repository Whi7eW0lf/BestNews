package news.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {


    @GetMapping("/news")
    public ModelAndView getNews(ModelAndView modelAndView){

        modelAndView.setViewName("news");

        return modelAndView;

    }


}
