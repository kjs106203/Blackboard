package kjs.Blackboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@ConfigurationProperties(prefix = "custom.strings")
public class BlackboardController {
    private ArticleRepository articleRepository;
    private String welcome;

    public BlackboardController(ArticleRepository m_articleRepository) {
        this.articleRepository = m_articleRepository;
    }

    @Autowired
    ArticleService articleService;

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String type, @RequestParam(required = false) String keyword, Model model) {
        Iterable<Article> articles;

        List<Article> res = articleService.selectStartWith("This");
        System.out.println(res);

        System.out.println(welcome);

        if (type == null) {
            articles = articleRepository.findAll();
        } else {
            switch (type) {
                case "title" :
                    articles = articleRepository.findByTitleContainingIgnoreCase(keyword);
                    break;
                case "author" :
                    articles = articleRepository.findByAuthorIgnoreCaseOrderByDateDesc(keyword);
                    break;
                case "content" :
                    articles = articleRepository.findByContentContainingIgnoreCaseOrderByDate(keyword);
                    break;
                default:
                    articles = articleRepository.findAll();
            }
        }
        model.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        Optional<Article> result = articleRepository.findById(id);

        model.addAttribute("content", result.get().getContent());

        return "view";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/write")
    public String write(Model model) {
        return "write";
    }

    @PostMapping("/write")
    public String getArticle(@ModelAttribute("article") Article article) { //jsp에서 commandname을 "article"로 설정 article은 Article이라는 자료형으로 만든 변수고 웹브라우저에서 작성한 내용이 담기는 곳
        articleService.insertArticle(article);

        List<Article> result = articleRepository.findByAuthorIgnoreCaseOrderByDateDesc(article.getAuthor()); //사용자의 가장 최신글을 찾아 사용자의 이름을 result에 저장
        int id = result.get(0).getId(); //사용자가 최근에 작성한 글의 id번호

        return "redirect:/view?id=" + String.valueOf(id);
    }
}