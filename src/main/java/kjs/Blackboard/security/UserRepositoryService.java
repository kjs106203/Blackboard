package kjs.Blackboard.security;

import kjs.Blackboard.User;
import kjs.Blackboard.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryService implements UserDetailsService {
    public UserRepository userRepository;

    @Autowired //userRepository를 Spring에서 구현해주는데 그것을 사용자가 만든 것과 연동을 시켜줌
    public UserRepositoryService(UserRepository m_userRepository) {
        this.userRepository = m_userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User not found.");
    }
}
