package news.repositories;

import news.models.Category;
import news.models.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,String> {

    @Query("SELECT n from News as n ORDER BY n.views DESC")
    List<News> getAllNewsOrderByViews(Pageable pageable);

    List<News> findAllByDateAfterOrderByDateDesc(Pageable pageable,LocalDateTime zeroDate);

    List<News> findAllByCategoryOrderByDateDesc(Category category, Pageable pageable);

    News getNewsById(String id);

}
