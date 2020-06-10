package news.web.controllers;

import news.services.interfaces.NewsService;
import news.services.models.CentralPlateServiceModel;
import news.services.models.TrendingNowModel;
import news.web.models.CentralPlateView;
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

        CentralPlateServiceModel news = this.newsService.getNews();
        CentralPlateView newsView = this.modelMapper.map(news, CentralPlateView.class);

        modelAndView.addObject("topNews",newsView);


        List<TrendingNowModel> trendingNews = this.newsService.getTrendingNowNews()
                .stream()
                .map(n -> this.modelMapper.map(n, TrendingNowModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("trendingNews",trendingNews);

        System.out.println("User IP: "+request.getRemoteAddr());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact(HttpServletRequest request){
        System.out.println("User IP: "+request.getRemoteAddr());
        return new ModelAndView("contact");
    }
}
