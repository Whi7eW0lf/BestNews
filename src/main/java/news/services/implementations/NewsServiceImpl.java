package news.services.implementations;

import news.models.Category;
import news.models.News;
import news.repositories.NewsRepository;
import news.services.interfaces.NewsService;
import news.services.models.CentralPlateServiceModel;
import news.services.models.NewsModel;
import news.services.models.SmallPlateCategoryServiceModel;
import news.services.models.TrendingNowModel;
import news.util.TextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    private static final LocalDateTime ZERO_DATE = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0);

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }



    @Override
    public List<CentralPlateServiceModel> getFourLastNews() { //TODO: TEST CODE!!!

        List<CentralPlateServiceModel> news = new ArrayList<>();

        this.newsRepository.findAllByDateAfterOrderByDateDesc(PageRequest.of(0, 4), ZERO_DATE)
                .forEach(n->{
                    CentralPlateServiceModel model = new CentralPlateServiceModel();

                    model.setTitle(n.getTitle()); //TODO: Custom model mapper
                    model.setDate(n.getDate()); //TODO: Custom model mapper
                    model.setCategory(n.getCategory().getType()); //TODO: Custom model mapper
                    model.setAuthor(n.getUser().getFirstName() + " " + n.getUser().getLastName()); //TODO: Custom model mapper
                    model.setImageUrl(n.getImageUrl()); //TODO: Custom model mapper
                    model.setId(n.getId());
                    news.add(model);

                });


        return news;
    }

    @Override
    public List<TrendingNowModel> getTrendingNowNews() {

        List<TrendingNowModel> trendingNews = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, 5);

        this.newsRepository.getAllNewsOrderByViews(pageable).forEach(n -> {
            TrendingNowModel model = new TrendingNowModel();
            model.setId(n.getId());
            model.setTitle(n.getTitle());
            trendingNews.add(model);
        });

        return trendingNews;
    }

    @Override
    public NewsModel getNews(String id) {

        News news = this.newsRepository.getNewsById(id);

        NewsModel model = new NewsModel();

        model.setAuthorNames(news.getUser().getFirstName() + " " + news.getUser().getLastName());
        model.setCategory(news.getCategory().getType());
        model.setDate(news.getDate());
        model.setTitle(news.getTitle());
        model.setTag(news.getTags());
        model.setText(TextEditor.makeNewsTextForParagraphs(news.getTextNews()));
        model.setViews(news.getViews());
        model.setCategory(news.getCategory().getType());
        model.setImageUrl(news.getImageUrl());
        model.setId(news.getId());

        return model;
    }

    @Override
    public List<SmallPlateCategoryServiceModel> getCategoryNews(Category category, int count) {

        List<SmallPlateCategoryServiceModel> news = new ArrayList<>();

        this.newsRepository.findAllByCategoryOrderByDateDesc(category,PageRequest.of(0, count,Sort.by(Sort.Direction.DESC,"date")))
                .forEach(n->{
                    SmallPlateCategoryServiceModel model = new SmallPlateCategoryServiceModel();
                    model.setCategory(n.getCategory());
                    model.setDate(n.getDate());
                    model.setImageUrl(n.getImageUrl());
                    model.setTitle(n.getTitle());
                    model.setId(n.getId());
                    news.add(model);
                });

        return news;
    }


}
