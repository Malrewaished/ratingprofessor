package com.example.finalproject.service;

import com.example.finalproject.dto.CommentRatingsDto;
import com.example.finalproject.model.CommentRating;
import com.example.finalproject.repository.CommentRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentRatingService {

    private final CommentRatingRepository commentRatingRepository;

    public List<CommentRating> getCommentRating() {
        return commentRatingRepository.findAll();
    }

    public void createCommentRating(CommentRating commentRating) {
        commentRatingRepository.save(commentRating);
    }

    public CommentRatingsDto getAllCommentsByProfessorId(Integer professorId) {
        CommentRatingsDto dto = new CommentRatingsDto();
        List<CommentRating> ratings = commentRatingRepository.findByProfessorId(professorId);
        Integer one = 0;
        Integer two = 0;
        Integer three = 0;
        Integer four = 0;
        Integer five = 0;
        for (CommentRating comments : ratings) {
            switch (comments.getRating()) {
                case 1:
                    one += 1;
                    break;
                case 2:
                    two += 1;
                    break;
                case 3:
                    three += 1;
                    break;
                case 4:
                    four += 1;
                    break;
                case 5:
                    five += 1;
                    break;
                default:
                    break;
            }
        }
        dto.setCommentRatingList(ratings);
        dto.setNumOnes(one);
        dto.setNumTwo(two);
        dto.setNumThree(three);
        dto.setNumFour(four);
        dto.setNumFive(five);
        if(ratings.size()>0){
            dto.setAvg(((one)+(two*2)+(three*3)+(four*4)+(five*5))/ratings.size());
        }else{
            dto.setAvg(0);
        }
        return dto;
    }

    public void updateComment(CommentRating commentRating, Integer id) {
        CommentRating oldComment = commentRatingRepository.getById(id);
        oldComment.setComment(commentRating.getComment());
        oldComment.setRating(commentRating.getRating());
        oldComment.setGrade(commentRating.getGrade());
        commentRatingRepository.save(oldComment);
    }

    public void deleteComment(Integer id) {
        commentRatingRepository.deleteById(id);
    }
}

