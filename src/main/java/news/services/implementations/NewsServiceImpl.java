package news.services.implementations;

import news.models.News;
import news.repositories.NewsRepository;
import news.services.interfaces.NewsService;
import news.services.models.CentralPlateServiceModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CentralPlateServiceModel getNews(){
        News news = this.newsRepository.findAll().get(0);

        CentralPlateServiceModel model =  new CentralPlateServiceModel();

        model.setTitle(news.getTitle());
        model.setDate(news.getDate().toString());
        model.setCategory(news.getCategory().iterator().next().getType());
        model.setAuthor(news.getUser().getFirstName()+" "+news.getUser().getLastName());
        model.setImgUrl(news.getImageLink());

        return model;
    }
}
