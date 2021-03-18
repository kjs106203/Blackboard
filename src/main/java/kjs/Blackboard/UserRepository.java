package kjs.Blackboard;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { //스트림(<>안에 들어가는것)으로 클래스 이름과 primary key의 자료형이 들어감
    User findByUsername(String username);

}
