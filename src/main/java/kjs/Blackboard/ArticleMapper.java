package kjs.Blackboard;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> selectStartWith(String start);
    void insertArticle(Article article);
}
