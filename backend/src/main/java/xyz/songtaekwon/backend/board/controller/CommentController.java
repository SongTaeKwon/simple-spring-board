package xyz.songtaekwon.backend.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.songtaekwon.backend.board.dto.CreateCommentRequest;
import xyz.songtaekwon.backend.board.dto.UpdateCommentRequest;
import xyz.songtaekwon.backend.board.service.CommentService;

@RequiredArgsConstructor
@RequestMapping("/api/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@RequestBody CreateCommentRequest request) {
        commentService.createComment(request);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
