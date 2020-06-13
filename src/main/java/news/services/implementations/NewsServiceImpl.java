package news.services.implementations;

import news.models.Category;
import news.models.News;
import news.repositories.NewsRepository;
import news.services.interfaces.NewsService;
import news.services.models.*;
import news.util.TextEditor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    private static final LocalDateTime ZERO_DATE = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0);

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<NewsModel> getLastNews(int count) { //TODO: TEST CODE!!!

        List<NewsModel> news = new ArrayList<>();

        this.newsRepository.findAllByDateAfterOrderByDateDesc(PageRequest.of(0, count), ZERO_DATE)
                .forEach(n->{
                    NewsModel model = new NewsModel();

                    model.setTitle(n.getTitle()); //TODO: Custom model mapper
                    model.setDate(n.getDate()); //TODO: Custom model mapper
                    model.setCategory(n.getCategory().getType()); //TODO: Custom model mapper
                    model.setImageUrl(n.getImageUrl()); //TODO: Custom model mapper
                    model.setId(n.getId());
                    model.setAuthorNames(n.getUser().getFirstName() + " " + n.getUser().getLastName());
                    news.add(model);

                });


        return news;
    }

    @Override
    public List<NewsModel> getTrendingNowNews() {

        List<NewsModel> trendingNews = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, 5);

        this.newsRepository.getAllNewsOrderByViews(pageable).forEach(n -> {
            NewsModel model = new NewsModel();
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
    public List<NewsModel> getPopularNews(int count) {

        List<NewsModel> popularNews = new ArrayList<>();

         this.newsRepository.getAllNewsOrderByViews(PageRequest.of(0, count))
                 .forEach(n->{
                     NewsModel model = new NewsModel();
                     model.setTitle(n.getTitle());
                     model.setDate(n.getDate());
                     model.setImageUrl(n.getImageUrl());
                     model.setId(n.getId());
                     popularNews.add(model);
                 });
        return popularNews;
    }

    @Override
    public List<SmallPlateCategoryServiceModel> getCategoryNews(CategoryServiceModel category, int count) {

        List<SmallPlateCategoryServiceModel> news = new ArrayList<>();
        Category mapped = this.modelMapper.map(category,Category.class);

        this.newsRepository.findAllByCategoryOrderByDateDesc(mapped,PageRequest.of(0, count,Sort.by(Sort.Direction.DESC,"date")))
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
