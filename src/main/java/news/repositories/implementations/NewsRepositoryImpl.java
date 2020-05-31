package news.repositories.implementations;

import news.repositories.interfaces.NewsRepository;
import news.services.models.CentralPlateServiceModel;
import news.services.models.RightPlateServiceModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository {

    @Override
    public CentralPlateServiceModel findTopNews() {
        return makeTopNews();
    }

    @Override
    public List<RightPlateServiceModel> findPopularNews() {
        return makePopularNews();
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING!!!
     */

    private List<RightPlateServiceModel> makePopularNews() {

        List<RightPlateServiceModel> popularNews = new ArrayList<>();

        RightPlateServiceModel rightRectangularPlate = new RightPlateServiceModel();

        rightRectangularPlate.setImgUrl("/images/test-image-1000x466.jpg");
        rightRectangularPlate.setCategory("TestServiceCategory");
        rightRectangularPlate.setTitle("Testing news service - Right Rectangular Plate");

        popularNews.add(rightRectangularPlate);

        RightPlateServiceModel x743Plate = new RightPlateServiceModel();

        x743Plate.setImgUrl("/images/test-image-1000x743.jpg");
        x743Plate.setCategory("TestServiceCategory");
        x743Plate.setTitle("Testing news service - Right First Plate");

        popularNews.add(x743Plate);

        RightPlateServiceModel secondX743Plate = new RightPlateServiceModel();

        secondX743Plate.setImgUrl("/images/test-image-1000x743second.jpg");
        secondX743Plate.setCategory("TestServiceCategory");
        secondX743Plate.setTitle("Testing news service - Right Second Plate");

        popularNews.add(secondX743Plate);

        return popularNews;
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING!!!
     */

    private CentralPlateServiceModel makeTopNews() {

        CentralPlateServiceModel topNews = new CentralPlateServiceModel();

        topNews.setImgUrl("/images/test-image-1000x840.jpg");
        topNews.setAuthor("Salih");
        topNews.setCategory("TestServiceCategory");
        topNews.setTitle("Testing news service");
        topNews.setDate("30.05.2020");

        return topNews;
    }

}
