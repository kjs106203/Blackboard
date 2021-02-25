package kjs.Blackboard.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
                    .logoutSuccessUrl("/")
                .and()
                    .csrf().disable();//암호화 방지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth); 부모꺼 안씀
        auth.inMemoryAuthentication()
                .withUser("jiseong")
                .password("{noop}1234")
                .authorities("ROLE_USER");
    }
}
