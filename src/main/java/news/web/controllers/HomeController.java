package news.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView getIndex(HttpServletRequest request){
        System.out.println("User IP: "+request.getRemoteAddr());
        return new ModelAndView("index");
    }
    @GetMapping("/news")
    public ModelAndView getNews(HttpServletRequest request){
        System.out.println("User IP: "+request.getRemoteAddr());
        return new ModelAndView("news");
    }
    @GetMapping("/contact")
    public ModelAndView getContact(HttpServletRequest request){
        System.out.println("User IP: "+request.getRemoteAddr());
        return new ModelAndView("contact");
    }
}
