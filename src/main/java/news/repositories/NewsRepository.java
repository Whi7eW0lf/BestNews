package news.repositories;

import news.models.Category;
import news.models.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,String> {

    List<News> findAllByDateAfterOrderByViewsDesc(LocalDateTime date, Pageable pageable);
    List<News> findAllByDateAfterOrderByDateDesc(Pageable pageable,LocalDateTime zeroDate);
    List<News> findAllByCategory (Category category, Pageable pageable);

    News getNewsById(String id);

}
