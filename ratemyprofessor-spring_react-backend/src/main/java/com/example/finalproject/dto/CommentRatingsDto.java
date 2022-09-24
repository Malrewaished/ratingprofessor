package com.example.finalproject.dto;

import com.example.finalproject.model.CommentRating;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentRatingsDto {
    private List<CommentRating> commentRatingList;
    private Integer numOnes=0;
    private Integer numTwo=0;
    private Integer numThree=0;
    private Integer numFour=0;
    private Integer numFive=0;
    private Integer avg=0;
}
