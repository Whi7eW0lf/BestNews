package news.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }
    @GetMapping("/news")
    public ModelAndView getNews(){
        return new ModelAndView("news");
    }
}
