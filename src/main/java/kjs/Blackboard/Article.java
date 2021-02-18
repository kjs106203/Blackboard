package kjs.Blackboard;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Article {
    private String title;
    private String author;
    private String password;
    @Id
    private int id;
    private Timestamp date;
    private String content;
}
