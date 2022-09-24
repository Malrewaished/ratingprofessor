package com.example.finalproject.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class CommentRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickName;
    private String comment;
    private String grade;
    private Integer professorId;
    private Integer rating;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
//    private Integer User_Id;

}
