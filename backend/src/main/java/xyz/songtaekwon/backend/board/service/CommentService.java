package xyz.songtaekwon.backend.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.songtaekwon.backend.board.dto.CreateCommentRequest;
import xyz.songtaekwon.backend.board.dto.UpdateCommentRequest;
import xyz.songtaekwon.backend.board.entity.Article;
import xyz.songtaekwon.backend.board.entity.Comment;
import xyz.songtaekwon.backend.board.repository.ArticleRepository;
import xyz.songtaekwon.backend.board.repository.CommentRepository;

@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void createComment(CreateCommentRequest request) {
        Article article = articleRepository.findById(request.getArticleId()).orElseThrow();
        Comment comment = new Comment(article, request.getContent());
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setContent(request.getContent());
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(comment);
    }
}
