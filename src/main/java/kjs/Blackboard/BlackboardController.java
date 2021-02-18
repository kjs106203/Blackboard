package kjs.Blackboard;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlackboardController {
    private ArticleRepository articleRepository;

    public BlackboardController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Article> result = articleRepository.findAll();

        model.addAttribute("articles", result);

        return "index"; //spring은 주로 웹뷰로 templates에서 찾지만 jsp는 web-inf에 들어가도록 설계 (application.yml 참조)
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        Optional<Article> result = articleRepository.findById(id);

        model.addAttribute("content", result.get().getContent());

        return "view";
    }
}
