package news.web.controllers;

import news.models.Category;
import news.repositories.CategoryRepository;
import news.services.interfaces.NewsService;
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
    private final CategoryRepository categoryRepository;//TODO: !!! TESTING !!!

    @Autowired
    public HomeController(ModelMapper modelMapper, NewsService newsService, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public ModelAndView getIndex(HttpServletRequest request, ModelAndView modelAndView) {

        List<TrendingNowModel> trendingNews = this.newsService.getTrendingNowNews()
                .stream()
                .map(n -> this.modelMapper.map(n, TrendingNowModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("trendingNews", trendingNews);

        List<CentralPlateView> news = this.newsService.getFourLastNews()
                .stream()
                .map(n -> this.modelMapper.map(n, CentralPlateView.class))
                .collect(Collectors.toList());

        modelAndView.addObject("topNews", news);

        Category category = this.categoryRepository.findById("c302d828-25b9-4b4c-b1c5-b381c706bb98").orElse(null);

        List<SmallPlateCategoryView> categoryNews =
                this.newsService.getCategoryNews(category)
                        .stream()
                        .map(n -> this.modelMapper.map(n, SmallPlateCategoryView.class))
                        .collect(Collectors.toList());

        modelAndView.addObject("categoryNews",categoryNews);

        System.out.println("User IP: " + request.getRemoteAddr());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact(HttpServletRequest request) {
        System.out.println("User IP: " + request.getRemoteAddr());
        return new ModelAndView("contact");
    }
}
