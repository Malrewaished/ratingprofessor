package com.example.finalproject.configuration;

import com.example.finalproject.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .authorizeRequests()
                // User
                .antMatchers("/api/v1/student/register/**").permitAll()
                .antMatchers("/api/v1/student/login/**").permitAll()
                .antMatchers("/api/v1/student").permitAll()
                .antMatchers("/api/v1/student/update/{id}").permitAll()
                .antMatchers("/api/v1/student/delete/{id}").hasAuthority("Admin")
                //Admin
                .antMatchers("/api/v1/admin").permitAll()
                .antMatchers("/api/v1/admin/login").permitAll()
                //Comment
                .antMatchers("/api/v1/rating").permitAll()
                .antMatchers("/api/v1/rating/{id}").permitAll()
                .antMatchers("/api/v1/rating/comments/{id}").permitAll()
                // Professors
                .antMatchers("/api/v1/professors").permitAll()
                .antMatchers("/api/v1/professors/{id}").permitAll()

                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/student/logout").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and()
                .httpBasic();
//                .authenticationEntryPoint(entryPoint());
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "OPTIONS"));
        configuration.addAllowedMethod(HttpMethod.TRACE);
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Bean
//    public AuthenticationEntryPoint entryPoint() {
//        return new BasicAuthenticationEntryPoint() {
//            @Override
//            public void commence(HttpServletRequest request, HttpServletResponse response,
//                                 AuthenticationException authException) throws IOException {
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                    response.setContentType("application/json");
//                    jsonObject.put("message", authException.getMessage());
//                    response.getWriter()
//                            .println(jsonObject);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void afterPropertiesSet() {
//                setRealmName("Auth");
//                super.afterPropertiesSet();
//            }
//        };
//    }

        }
