package news.services.interfaces;

import news.models.Category;
import news.services.models.*;

import java.util.List;
import java.util.Set;

public interface NewsService {

    List<NewsModel> getLastNews(int count);
    List<NewsModel> getTrendingNowNews();
    NewsModel getNews(String id);
    List<NewsModel> getPopularNews(int count);
    List<SmallPlateCategoryServiceModel> getCategoryNews(CategoryServiceModel category, int count);

}
