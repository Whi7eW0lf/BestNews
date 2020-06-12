package news.services.interfaces;

import news.models.Category;
import news.services.models.*;

import java.util.List;
import java.util.Set;

public interface NewsService {

    List<CentralPlateServiceModel> getFourLastNews();
    List<TrendingNowModel> getTrendingNowNews();
    NewsModel getNews(String id);
    List<SmallPlateCategoryServiceModel> getCategoryNews(CategoryServiceModel category, int count);

}
