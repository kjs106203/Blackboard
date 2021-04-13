package kjs.Blackboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Page<Article> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
