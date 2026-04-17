package xyz.songtaekwon.backend.board.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.songtaekwon.backend.board.dto.ArticleDetailResponse;
import xyz.songtaekwon.backend.board.dto.CreateArticleRequest;
import xyz.songtaekwon.backend.board.dto.UpdateArticleRequest;
import xyz.songtaekwon.backend.board.entity.Article;
import xyz.songtaekwon.backend.board.entity.Comment;
import xyz.songtaekwon.backend.board.repository.ArticleRepository;
import xyz.songtaekwon.backend.board.repository.CommentRepository;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ArticleDetailResponse getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        List<Comment> comments = commentRepository.findAllByArticleId(articleId);
        return new ArticleDetailResponse(article, comments);
    }

    @Transactional
    public void createArticle(CreateArticleRequest request) {
        Article article = new Article(request.getTitle(), request.getContent());
        articleRepository.save(article);
    }

    @Transactional
    public void updateArticle(Long id, UpdateArticleRequest request) {
        Article article = articleRepository.findById(id).orElseThrow();
        article.changeTitle(request.getTitle());
        article.changeContent(request.getContent());
        articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        commentRepository.deleteByArticleId(article.getId());
        articleRepository.delete(article);
    }
}
