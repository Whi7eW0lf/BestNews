package news.web.controllers;

import news.models.Category;
import news.services.interfaces.CategoryService;
import news.services.interfaces.NewsService;
import news.services.models.CategoryServiceModel;
import news.services.models.TrendingNowModel;
import news.web.models.CentralPlateView;
import news.web.models.SmallPlateCategoryView;
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

        List<TrendingNowModel> trendingNews = this.newsService.getTrendingNowNews()
                .stream()
                .map(n -> this.modelMapper.map(n, TrendingNowModel.class))
                .collect(Collectors.toList());


        List<CentralPlateView> news = this.newsService.getFourLastNews()
                .stream()
                .map(n -> this.modelMapper.map(n, CentralPlateView.class))
                .collect(Collectors.toList());


        SmallPlateCategoryView centralCategoryNews = getSmallCategoryNews("Weather", 1,0).get(0);

        List<SmallPlateCategoryView> smallCategoryNews = getSmallCategoryNews("Weather", 4,1);

        modelAndView.addObject("trendingNews", trendingNews);
        modelAndView.addObject("centralCategoryNews", centralCategoryNews);
        modelAndView.addObject("topNews", news);
        modelAndView.addObject("smallCategoryNews", smallCategoryNews);

        modelAndView.setViewName("index");
        System.out.println("User IP: " + request.getRemoteAddr());

        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact(HttpServletRequest request) {
        System.out.println("User IP: " + request.getRemoteAddr());
        return new ModelAndView("contact");
    }

    private List<SmallPlateCategoryView> getSmallCategoryNews(String categoryName, int count,int skip) {
        CategoryServiceModel category = this.categoryService.getCategoryByType(categoryName);

        return this.newsService.getCategoryNews(category, count)
                .stream()
                .skip(skip)
                .map(n -> this.modelMapper.map(n, SmallPlateCategoryView.class))
                .collect(Collectors.toList());
    }
}
