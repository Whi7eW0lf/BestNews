package news.web.controllers;

import news.services.interfaces.CategoryService;
import news.services.interfaces.NewsService;
import news.services.models.CategoryServiceModel;
import news.web.models.*;
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
    private final CategoryService categoryService;

    @Autowired
    public HomeController(ModelMapper modelMapper, NewsService newsService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ModelAndView getIndex(HttpServletRequest request, ModelAndView modelAndView) {

        List<TrendingNowView> trendingNews = this.newsService.getTrendingNowNews()
                .stream()
                .map(n -> this.modelMapper.map(n, TrendingNowView.class))
                .collect(Collectors.toList());


        List<CentralNewsView> news = this.newsService.getLastNews(4)
                .stream()
                .map(n -> this.modelMapper.map(n, CentralNewsView.class))
                .collect(Collectors.toList());


//        CategoryNewsView centralCategoryNews = getSmallCategoryNews("Weather", 1,0).get(0);

//        List<CategoryNewsView> smallCategoryNews = getSmallCategoryNews("Weather", 4,1);

        List<LatestArticlesView> latestArticles = this.newsService.getLastNews(6)
                .stream()
                .map(n->this.modelMapper.map(n,LatestArticlesView.class))
                .collect(Collectors.toList());

        List<PopularNewsView> popularNews = this.newsService.getPopularNews(3)
                .stream()
                .map(n->this.modelMapper.map(n,PopularNewsView.class))
                .collect(Collectors.toList());

        modelAndView.addObject("popularNews",popularNews);
        modelAndView.addObject("popularNews2",popularNews);

        modelAndView.addObject("latestArticles",latestArticles);
        modelAndView.addObject("trendingNews", trendingNews);
//        modelAndView.addObject("centralCategoryNews", centralCategoryNews);
        modelAndView.addObject("topNews", news);
//        modelAndView.addObject("smallCategoryNews", smallCategoryNews);

        modelAndView.setViewName("index");

        System.out.println("User IP: " + request.getRemoteAddr());

        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact(HttpServletRequest request) {
        System.out.println("User IP: " + request.getRemoteAddr());
        return new ModelAndView("contact");
    }

    private List<CategoryNewsView> getSmallCategoryNews(String categoryName, int count, int skip) {
        CategoryServiceModel category = this.categoryService.getCategoryByType(categoryName);

        return this.newsService.getCategoryNews(category, count)
                .stream()
                .skip(skip)
                .map(n -> this.modelMapper.map(n, CategoryNewsView.class))
                .collect(Collectors.toList());
    }
}
