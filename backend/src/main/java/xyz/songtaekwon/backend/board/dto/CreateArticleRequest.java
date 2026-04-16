package xyz.songtaekwon.backend.board.dto;

public class CreateArticleRequest {
    private String title;
    private String content;

    protected CreateArticleRequest() {

    }

    public CreateArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
