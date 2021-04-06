package kjs.Blackboard;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
@Alias("article") //자바 클래스로 데이터 클래스를 정의, mybatis는 쿼리를 xml에 저장, xml에서 인식을 하지 못하여 데이터 클래스라는 것이라고 알리기 위해
public class Article {
    private String title;
    private String author;
    private String password;
    @Id
    private int id;
    private Timestamp date;
    private String content;
}
