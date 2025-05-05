package com.blog.mini_blogger_app.service;

import com.blog.mini_blogger_app.dto.UserLoginDto;
import com.blog.mini_blogger_app.dto.UserRegisterDto;
import com.blog.mini_blogger_app.dto.UserResponseDto;
import com.blog.mini_blogger_app.entity.User;
import com.blog.mini_blogger_app.exception.UserAlreadyExistsException;
import com.blog.mini_blogger_app.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;




    public ResponseEntity<UserResponseDto> register(UserRegisterDto userRegisterDto) {

        if(userRepository.findByEmail(userRegisterDto.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException("user already exists "+userRegisterDto.getEmail());
        }

        User user=convertUserRequestToUser(userRegisterDto);
        userRepository.save(user);
        UserResponseDto userResponseDto = convertUserToUserResponseDto(user);

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto, HttpServletRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUserName(), loginDto.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            User user=userRepository.findByEmail(loginDto.getUserName()).orElseThrow(
                    ()-> new UsernameNotFoundException("user not found "+loginDto.getUserName()));
            UserResponseDto userResponseDto=convertUserToUserResponseDto(user);

            return new ResponseEntity<>(userResponseDto,HttpStatus.OK);

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    private User convertUserRequestToUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUserName(userRegisterDto.getUserName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        return user;
    }

    private UserResponseDto convertUserToUserResponseDto(User user)
    {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUserName(user.getUserName());
        return userResponseDto;
    }
    private User convertUserLoginDtoToUser(UserLoginDto userLoginDto)
    {
        User user=new User();
        user.setEmail(userLoginDto.getUserName());
        user.setPassword(userLoginDto.getPassword());
        return user;
    }
}
