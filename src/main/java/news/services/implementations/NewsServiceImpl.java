package news.services.implementations;

import news.models.News;
import news.repositories.NewsRepository;
import news.services.interfaces.NewsService;
import news.services.models.CentralPlateServiceModel;
import news.services.models.TrendingNowModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;

    private static final LocalDateTime NOW = LocalDateTime.now();
    private static final LocalDateTime MIDNIGHT = NOW.toLocalDate().atStartOfDay();

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CentralPlateServiceModel getNews() {

        News news = this.newsRepository.findAll().get(0);

        CentralPlateServiceModel model = new CentralPlateServiceModel();

        model.setTitle(news.getTitle()); //TODO: Custom model mapper
        model.setDate(news.getDate().toString()); //TODO: Custom model mapper
        model.setCategory(news.getCategory().iterator().next().getType()); //TODO: Custom model mapper
        model.setAuthor(news.getUser().getFirstName() + " " + news.getUser().getLastName()); //TODO: Custom model mapper
        model.setImgUrl(news.getImageLink()); //TODO: Custom model mapper

        return model;
    }

    @Override
    public List<TrendingNowModel> getTrendingNowNews() {

        List<TrendingNowModel> trendingNews = new ArrayList<>();

        this.newsRepository.findNewsByDateIsAfterOrderByViewsDesc(MIDNIGHT).stream().limit(5).forEach(n -> {
            TrendingNowModel model = new TrendingNowModel();
            model.setId(n.getId());
            model.setTitle(n.getTitle());
            trendingNews.add(model);
        });

        return trendingNews;
    }
}
