package com.example.finalproject.service;
import com.example.finalproject.dto.RegisterForm;
import com.example.finalproject.exception.InvalidCredentialsException;
import com.example.finalproject.model.Admin;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.AdminRepository;
import com.example.finalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public void register(RegisterForm registerForm) {
//        String hashedPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
//        registerForm.setPassword(hashedPassword);
        User user = new User(null, registerForm.getNickName(), registerForm.getEmail(), registerForm.getPassword(),null);
        userRepository.save(user);
}

    public User loginAsUser(User user) throws InvalidCredentialsException {
//        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User findUser = userRepository.findByUserPasswordAndEmail(user.getEmail(), user.getPassword());
        if (findUser == null)
            throw new InvalidCredentialsException("Invalid Credentials");
        return findUser;
    }

    public void updateUser(User user, Integer id) {
        User oldUser = userRepository.getById(id);
        oldUser.setNickName(user.getNickName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }
}
