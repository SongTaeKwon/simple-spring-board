package xyz.songtaekwon.backend.board.dto;

public class UpdateCommentRequest {

    private String content;

    protected UpdateCommentRequest() {

    }

    public UpdateCommentRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
