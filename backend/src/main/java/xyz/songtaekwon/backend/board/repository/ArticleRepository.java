package xyz.songtaekwon.backend.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.songtaekwon.backend.board.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
