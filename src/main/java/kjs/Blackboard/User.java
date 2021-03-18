package kjs.Blackboard;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String name;
    private String phone;
    private int age;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }


//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }       lombok으로 자동 생성 되기 때문에 삭제

    @Override
    public boolean isAccountNonExpired() { //계정 만료기간
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정 휴면
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //로그인 시 인증 방법
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
