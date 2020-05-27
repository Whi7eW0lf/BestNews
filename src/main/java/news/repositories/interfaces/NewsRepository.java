package news.repositories.interfaces;

import news.services.models.CentralPlateServiceModel;
import news.services.models.RightPlateServiceModel;

import java.util.List;

public interface NewsRepository {
    CentralPlateServiceModel findTopNews();
    List<RightPlateServiceModel> findPopularNews();
}
