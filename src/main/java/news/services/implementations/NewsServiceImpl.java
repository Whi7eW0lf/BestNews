package news.services.implementations;

import news.repositories.interfaces.NewsRepository;
import news.services.interfaces.NewsService;
import news.services.models.CentralPlateServiceModel;
import news.services.models.RightPlateServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public CentralPlateServiceModel getTopNews() {
        return this.newsRepository.findTopNews();
    }

    @Override
    public List<RightPlateServiceModel> getPopularNews() {
        return this.newsRepository.findPopularNews();
    }

}
