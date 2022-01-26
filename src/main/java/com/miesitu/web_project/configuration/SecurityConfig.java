package com.miesitu.web_project.configuration;
import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);// Log in by username
            if (user != null) return user;

            user = userRepo.findByEmail(username);// login by phone
            if (user != null) return user;
            
            int phone = 0;
            try{
                phone = Integer.parseInt(username); //login by email
                System.out.println(phone);
            }
            catch (NumberFormatException ex){
                //do nothing
            }
            if(phone != 0 ){
                user = userRepo.findByPhone(phone);
                if (user != null) return user;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http

            .authorizeRequests()
                // .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                // .antMatchers("/cust", "/cust/**").hasRole("CUSTOMER")
                // .antMatchers("/dist", "/dist/**").hasRole("DISTRIBUTER")
                .antMatchers("/signup").anonymous()
                .antMatchers("/", "/**").permitAll()
            .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error").permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
            .and()
            .build();
    }
}
