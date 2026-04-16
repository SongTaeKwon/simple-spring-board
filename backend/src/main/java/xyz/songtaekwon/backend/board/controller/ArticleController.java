package xyz.songtaekwon.backend.board.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.songtaekwon.backend.board.dto.ArticleDetailResponse;
import xyz.songtaekwon.backend.board.dto.CreateArticleRequest;
import xyz.songtaekwon.backend.board.dto.UpdateArticleRequest;
import xyz.songtaekwon.backend.board.entity.Article;
import xyz.songtaekwon.backend.board.service.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleDetailResponse getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping
    public void createArticle(@RequestBody CreateArticleRequest request) {
        articleService.createArticle(request);
    }

    @PutMapping("/{id}")
    public void updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        articleService.updateArticle(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
