package news.services.interfaces;

import news.services.models.CentralPlateServiceModel;
import news.services.models.TrendingNowModel;

import java.util.List;
import java.util.Set;

public interface NewsService {

    CentralPlateServiceModel getNews();
    List<TrendingNowModel> getTrendingNowNews();

}
