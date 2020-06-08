package news.web.controllers;

import news.services.interfaces.NewsService;
import news.services.models.CentralPlateServiceModel;
import news.tests.AddDatabaseInformation;
import news.web.models.CentralPlateView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final ModelMapper modelMapper;
    private final NewsService newsService;
    private final AddDatabaseInformation add;
    private static int count = 0;

    @Autowired
    public HomeController(ModelMapper modelMapper, NewsService newsService, AddDatabaseInformation add) {
        this.modelMapper = modelMapper;
        this.newsService = newsService;
        this.add = add;
    }

    @GetMapping("/")
    public ModelAndView getIndex(HttpServletRequest request, ModelAndView modelAndView){

        CentralPlateServiceModel news = this.newsService.getNews();

        CentralPlateView map = this.modelMapper.map(news, CentralPlateView.class);

        modelAndView.addObject("topNews",map);
        modelAndView.setViewName("index");

        System.out.println("User IP: "+request.getRemoteAddr());

        if (count==0){

            this.add.addUser();
            this.add.addTag();
            this.add.addCategory();
            this.add.addNews();

            count++;
        }

        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact(HttpServletRequest request){
        System.out.println("User IP: "+request.getRemoteAddr());
        return new ModelAndView("contact");
    }
}
