package kjs.Blackboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "kjs.Blackboard")
public class BlackboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlackboardApplication.class, args);
    }
}
