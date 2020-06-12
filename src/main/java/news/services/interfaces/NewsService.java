package news.services.interfaces;

import news.models.Category;
import news.services.models.CentralPlateServiceModel;
import news.services.models.NewsModel;
import news.services.models.SmallPlateCategoryServiceModel;
import news.services.models.TrendingNowModel;

import java.util.List;
import java.util.Set;

public interface NewsService {

    List<CentralPlateServiceModel> getFourLastNews();
    List<TrendingNowModel> getTrendingNowNews();
    NewsModel getNews(String id);
    List<SmallPlateCategoryServiceModel> getCategoryNews(Category category,int count);

}
