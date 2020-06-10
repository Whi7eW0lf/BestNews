package news.repositories;

import news.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,String> {

    List<News> findNewsByDateIsAfterOrderByViewsDesc(LocalDateTime date);

}
