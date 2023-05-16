package com.kch.service.service;

import com.kch.persistence.entity.User;
import com.kch.persistence.repository.UserRepository;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.enums.UserRole;
import com.kch.service.model.mapper.UserMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    /*    @AfterEach
        void deleteAll(){
            userRepository.deleteAll();
        }*/


    @Test
    @DisplayName("유저 생성이 올바르게 되는지 테스트")
    void createUser() {
        //given
        UserReqDTO.CREATE createDTO = UserReqDTO.CREATE.builder()
                .birth(LocalDateTime.of(1998, 10, 22, 0, 0))
                .name("창훈")
                .loginId("admin")
                .email("knkn9436@naver.com")
                .password("1234")
                .role(UserRole.ADMIN)
                .build();
        //when, then
        assertDoesNotThrow(() -> userService.createUser(createDTO));
    }

    @Test
    void getUserByUserId() {
        //given
        UserReqDTO.CREATE createDTO = UserReqDTO.CREATE.builder()
                .birth(LocalDateTime.of(2002, 10, 22, 0, 0))
                .name("예인")
                .loginId("user")
                .email("yein9436@naver.com")
                .password("1234")
                .role(UserRole.USER)
                .build();
        //when
        final User user = userMapper.toUserEntity(createDTO);
        Long id = userRepository.save(user).getId();
        //then
        assertDoesNotThrow(() -> userService.getUserByUserId(id));
    }

    @Test
    void updateUser() {
        //given
        //when
        //then
    }

    @Test
    void deleteUserByUserId() {
        //given
        //when
        //then
    }
}