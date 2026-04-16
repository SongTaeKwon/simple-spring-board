package xyz.songtaekwon.backend.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.songtaekwon.backend.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteByArticleId(Long articleId);

    List<Comment> findAllByArticleId(Long articleId);
}
