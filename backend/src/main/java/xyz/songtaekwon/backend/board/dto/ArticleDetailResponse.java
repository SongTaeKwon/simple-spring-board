package xyz.songtaekwon.backend.board.dto;

import java.util.List;
import lombok.Getter;
import xyz.songtaekwon.backend.board.entity.Article;
import xyz.songtaekwon.backend.board.entity.Comment;

@Getter
public class ArticleDetailResponse {

    private Long id;
    private String title;
    private String content;
    private List<Comment> comments;

    public ArticleDetailResponse(Article article, List<Comment> comments) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.comments = comments;
    }
}
