package kjs.Blackboard;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Mapper;
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

    com.github.pagehelper.Page<Article> selectStartWith(String start, int page ) { //page = 페이지 번호
        PageHelper.startPage(page, 2);
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
    com.github.pagehelper.Page<Article> findAll(int page) {
        PageHelper.startPage(page,2);
        return articleMapper.findAll();
    }
}
