package kjs.Blackboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleMapper articleMapper;

    List<Article> searchContent(String content) {
        return articleMapper.selectContent(content);
    }

    List<Article> selectStartWith(String start) {

        return articleMapper.selectStartWith(start);
    }

    void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    List<Article> selectAuthor (String name) {
        return articleMapper.selectAuthor(name);
    }

    Page<Article> searchTitle(String title, int page) {
        return articleRepository.findByTitleContainingIgnoreCase(title, PageRequest.of(page, 2));
    }
    Iterable<Article> findAll() {
        return articleRepository.findAll();
    }
}
