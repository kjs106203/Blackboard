package kjs.Blackboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception { //웹페이지 설정
        //super.configure(http); 부모꺼 안씀
        http
                .authorizeRequests()
                    .antMatchers("/").access("permitAll()")
                    .antMatchers("/view", "/write").access("hasRole('ROLE_USER')")

                .and()
                    //.httpBasic(); 로그인창이 단순하게 표시됨
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .logout()
                    .logoutSuccessUrl("/");
    }


    @Autowired //스프링 안에서 자동으로 다른 소스와 연동시킴
    DataSource dataSource; //application.yml에 datasource가 하나가 있으므로 그 datasource를 의미
                           // datasource가 하나만 있어서 autowired 가 가능

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth); 부모꺼 안씀
        auth.userDetailsService(userRepositoryService).passwordEncoder(encoder());
    }
}
