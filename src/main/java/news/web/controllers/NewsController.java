package news.web.controllers;

import news.services.interfaces.NewsService;
import news.services.models.NewsModel;
import news.web.models.PopularNewsView;
import news.web.models.TrendingNowView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final ModelMapper modelMapper;
    private final NewsService newsService;

    @Autowired
    public NewsController(ModelMapper modelMapper, NewsService newsService) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
    }


    @GetMapping("/{newsId}")
    public ModelAndView getSelectedNewsNews(HttpServletRequest request, ModelAndView modelAndView, @PathVariable String newsId) {

        List<TrendingNowView> trendingNews = this.newsService.getTrendingNowNews()
                .stream()
                .map(n -> this.modelMapper.map(n, TrendingNowView.class))
                .collect(Collectors.toList());

        modelAndView.addObject("trendingNews", trendingNews);

        NewsModel news = this.modelMapper.map(this.newsService.getNews(newsId), NewsModel.class);

        List<PopularNewsView> popularNews = this.newsService.getPopularNews(3)
                .stream()
                .map(n->this.modelMapper.map(n,PopularNewsView.class))
                .collect(Collectors.toList());

        modelAndView.addObject("popularNews",popularNews);
        modelAndView.addObject("news", news);
        modelAndView.setViewName("news");

        System.out.println("User IP: " + request.getRemoteAddr());

        return modelAndView;

    }

    @GetMapping("")
    public ModelAndView getNews(ModelAndView modelAndView){
        modelAndView.setViewName("category");
        return modelAndView;
    }

}
