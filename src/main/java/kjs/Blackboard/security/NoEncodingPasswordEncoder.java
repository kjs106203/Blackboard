package kjs.Blackboard.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NoEncodingPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) { //암호화 해주는 메소드
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) { //암호화 된 결과물과 비교
        return charSequence.toString().equals(s);
    }
}
