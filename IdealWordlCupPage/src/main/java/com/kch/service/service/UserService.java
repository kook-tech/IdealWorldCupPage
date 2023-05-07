package com.kch.service.service;

import com.kch.infrastructure.error.DuplicatedException;
import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.User;
import com.kch.persistence.repository.UserRepository;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.dtos.response.UserResDTO;
import com.kch.service.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /*유저 생성 서비스
    param : 생성 유저 info*/
    @Transactional
    public void createUser(UserReqDTO.CREATE create){
        final User user = userMapper.toUserEntity(create);
        userRepository.save(user);
    }

    /*유저 정보 읽기 서비스
    param : 읽을 유저 아이디(pk)*/
    public UserResDTO.READ getUserByUserId(Long userId){
        final User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        return userMapper.toReadDto(user);
    }

    /*유저 정보 수정 서비스
    param : 수정 유저 아이디(pk), 수정 info*/
    @Transactional
    public void updateUser(Long userId, UserReqDTO.UPDATE update){
        User user = userRepository
                .findById(userId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        isEmailAlreadyExists(user.getEmail(), update.getEmail());

        user.updateUser(update);
    }

    /*유저 정보 삭제 서비스
    param : 삭제 유저 아이디(pk)*/
    @Transactional
    public void deleteUserByUserId(Long userId) {
        final User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        userRepository.delete(user);
    }

    /*유저 정보 수정시 이메일 중복 체크*/
    private void isEmailAlreadyExists(String email, String updateEmail){
        if(!email.equals(updateEmail)){
            if(userRepository.existsByEmail(updateEmail))
                throw new DuplicatedException(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        }

    }
}
