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
    private String welcome;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleService articleService;

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String type, @RequestParam(required = false) String keyword, @RequestParam(required = false) String page, Model model) {
        Iterable<Article> articles;

        int pages = 1;
        int p = 0;
        if(page != null) {
            p = Integer.parseInt(page);
        }

        List<Article> res = articleService.selectStartWith("This");
        System.out.println(res);

        System.out.println(welcome);

        if (type == null) {
            articles = articleService.findAll();
        } else {
            switch (type) {
                /*case "title" :
                    articles = articleService.searchTitle(keyword);
                    break;*/
                case "title" :
                    articles = articleService.searchTitle(keyword, p).getContent(); //getContent를 이용하여 List로 변환 웹에서는 Page대신 List를 인식하기 때문
                    pages = articleService.searchTitle(keyword, p).getTotalPages(); //게시글에 따라 페이지 수가 달라지는데 페이지 수를 측정
                    break;
                case "author" :
                    articles = articleService.selectAuthor(keyword);
                    break;
                case "content" :
                    articles = articleService.searchContent(keyword);
                    break;
                default:
                    articles = articleRepository.findAll();
            }
        }
        model.addAttribute("articles", articles);
        model.addAttribute("pages", pages);
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

        List<Article> result = articleService.selectAuthor(article.getAuthor()); //사용자의 가장 최신글을 찾아 사용자의 이름을 result에 저장
        int id = result.get(0).getId(); //사용자가 최근에 작성한 글의 id번호

        return "redirect:/view?id=" + String.valueOf(id);
    }
}