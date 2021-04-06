package kjs.Blackboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    List<Article> findByTitleContainingIgnoreCase(String title);
    List<Article> findByAuthorIgnoreCaseOrderByDateDesc(String author);
    List<Article> findByContentContainingIgnoreCaseOrderByDate(String content);

}
