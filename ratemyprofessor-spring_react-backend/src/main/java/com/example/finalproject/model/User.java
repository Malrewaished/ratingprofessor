package com.example.finalproject.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotEmpty (message = "اسم المستعار يجب ان لا يكون فارغاً")
        @Size(min = 4, message = "لا يمكن أن يكون اسم المستعار أقل من ٤ حروف")
        private String nickName;

        @NotEmpty(message = "يجب ألا يكون البريد الإلكتروني فارغًا")
        @Size(min = 5, message = "لا يمكن أن يكون البريد الإلكتروني أقل من 5 حروف")
        private String email;

        @NotEmpty (message = "كلمة السر يجب أن لا تكون فارغة")
        @Size(min = 6, message = "لا يمكن أن تكون كلمة السر أقل من 5 حروف")
        private String password;


//        @NotEmpty (message = "كلمة السر يجب أن لا تكون فارغة")
//        @Size(min = 6, message = "لا يمكن أن تكون كلمة السر أقل من 5 حروف")
//        private String confirmPassword;


        @Pattern(regexp = "(Admin|Student)")
        private String role;



        @JsonIgnore
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority(this.role));
        }

        @JsonIgnore
        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @JsonIgnore
        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @JsonIgnore
        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @JsonIgnore
        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public String getUsername() {
                return this.email;
        }
}
