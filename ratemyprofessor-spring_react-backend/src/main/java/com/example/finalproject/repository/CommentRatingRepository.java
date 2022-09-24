package com.example.finalproject.repository;

import com.example.finalproject.model.CommentRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRatingRepository extends JpaRepository<CommentRating, Integer> {

    @Query("select comment from CommentRating comment where comment.professorId=?1")
    List<CommentRating> findByProfessorId(Integer professorId);

}
