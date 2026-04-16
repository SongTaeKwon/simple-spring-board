package xyz.songtaekwon.backend.board.dto;

public class CreateCommentRequest {

    private Long articleId;

    private String content;

    protected CreateCommentRequest() {

    }

    public CreateCommentRequest(Long articleId, String content) {
        this.articleId = articleId;
        this.content = content;
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getContent() {
        return content;
    }
}
