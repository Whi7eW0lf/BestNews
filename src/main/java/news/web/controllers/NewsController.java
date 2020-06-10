package news.web.controllers;

import news.services.interfaces.NewsService;
import news.services.models.TrendingNowModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NewsController {

    private final ModelMapper modelMapper;
    private final NewsService newsService;

    @Autowired
    public NewsController(ModelMapper modelMapper, NewsService newsService) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
    }


    @GetMapping("/news/{id}")
    public ModelAndView getNews(ModelAndView modelAndView, @PathVariable(name = "id") String id){

        List<TrendingNowModel> trendingNews = this.newsService.getTrendingNowNews()
                .stream()
                .map(n -> this.modelMapper.map(n, TrendingNowModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("trendingNews",trendingNews);

        id="sad";
        modelAndView.setViewName("news");

        return modelAndView;

    }


}
