package kjs.Blackboard;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
//   jpa에 있는 페이지 방식 제목을 찾는 쿼리 작성 (ArticleMapper.xml에 작성)
//    List<Article> selectStartWith(String start);
//    void insertArticle(Article article);
    Page<Article> selectAuthor(String name);
    Page<Article> selectContent(String content);
    Page<Article> findAll();

    //mybatis와 pagehelper를 같이 쓰는 방식
    Page<Article> selectStartWith(String start);
    void insertArticle(Article article);
}
