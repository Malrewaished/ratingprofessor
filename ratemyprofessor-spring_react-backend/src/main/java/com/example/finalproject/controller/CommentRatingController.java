package com.example.finalproject.controller;

import com.example.finalproject.dto.Api;
import com.example.finalproject.model.CommentRating;
import com.example.finalproject.service.CommentRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rating")
public class CommentRatingController {

    private final CommentRatingService commentRatingService;

    @GetMapping
    public ResponseEntity getRating() {
        return ResponseEntity.status(201).body(commentRatingService.getCommentRating());
    }

    @PostMapping
    public ResponseEntity createCommentRating(@RequestBody @Valid CommentRating commentRating) {
        commentRatingService.createCommentRating(commentRating);
        return ResponseEntity.status(201).body(new Api("Comment added ", 201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Api> updateRating(@RequestBody @Valid CommentRating commentRating, @PathVariable Integer id) {
        commentRatingService.updateComment(commentRating, id);
        return ResponseEntity.status(201).body(new Api("Comment updated", 201));
    }

    @GetMapping("/comments/{professorId}")
    public ResponseEntity<?> getAllCommentsByProfessorId(@PathVariable(name = "professorId") Integer professorId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentRatingService.getAllCommentsByProfessorId(professorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Api> deleteComment(@PathVariable Integer id) {
        commentRatingService.deleteComment(id);
        return ResponseEntity.status(201).body(new Api("Comment deleted !", 201));
    }
}
