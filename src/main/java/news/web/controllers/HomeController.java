package news.web.controllers;

import news.services.interfaces.NewsService;
import news.web.models.CentralPlateView;
import news.web.models.RightPlateView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ModelMapper modelMapper;
    private final NewsService newsService;

    @Autowired
    public HomeController(ModelMapper modelMapper, NewsService newsService) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
    }

    @GetMapping("/")
    public ModelAndView getIndex(HttpServletRequest request, ModelAndView modelAndView){

        CentralPlateView topNews = this.modelMapper.map(this.newsService.getTopNews(), CentralPlateView.class);

        List<RightPlateView> popularNews = this.newsService.getPopularNews()
                .stream()
                .map(n -> this.modelMapper.map(n, RightPlateView.class))
                .collect(Collectors.toList());

        modelAndView.setViewName("index");
        modelAndView.addObject("topNews",topNews);
        modelAndView.addObject("popularNews",popularNews);

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
