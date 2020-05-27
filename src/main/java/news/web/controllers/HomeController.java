package news.web.controllers;

import news.web.models.NewsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView getIndex(HttpServletRequest request, ModelAndView modelAndView){
        NewsModel news = new NewsModel();


        news.setImgUrl("/images/test-image.jpg");
        news.setAuthor("Salih");
        news.setCategory("Test Category");
        news.setDate("27.05.2020");
        news.setTitle("News Model Test");



        modelAndView.setViewName("index");
        modelAndView.addObject("news",news);

        System.out.println("User IP: "+request.getRemoteAddr());
        return modelAndView;
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
