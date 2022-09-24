package com.example.finalproject.repository;
import com.example.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);
    @Query("select user from User user where user.email=?1 and user.password=?2")
    User findByUserPasswordAndEmail(String username, String password);

}
