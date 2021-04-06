package kjs.Blackboard;

import org.springframework.beans.factory.annotation.Autowired;
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
        return articleRepository.findByContentContainingIgnoreCaseOrderByDate(content);
    }

    List<Article> selectStartWith(String start) {
        return articleMapper.selectStartWith(start);
    }

    void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }
}
