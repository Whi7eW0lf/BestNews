package news.services.interfaces;

import news.services.models.CentralPlateServiceModel;
import news.services.models.RightPlateServiceModel;

import java.util.List;

public interface NewsService {
    CentralPlateServiceModel getTopNews();
    List<RightPlateServiceModel> getPopularNews();
}
