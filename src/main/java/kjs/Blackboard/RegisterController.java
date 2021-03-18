package kjs.Blackboard;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository m_userRepository, PasswordEncoder m_passwordEncoder) { //명칭은 메소드 역할은 생성자
        userRepository = m_userRepository;
        passwordEncoder = m_passwordEncoder;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String getRegister(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "redirect:/login";
    }
}

