package com.kch.controller;

import com.kch.infrastructure.error.DuplicatedException;
import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.dtos.response.UserResDTO;
import com.kch.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /*유저 생성 컨트롤러
    param : 생성 유저 info*/
    @PostMapping
    public ResponseFormat<Void> createUser(@RequestBody @Validated UserReqDTO.CREATE create) {
        try {
            userService.createUser(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (DuplicatedException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }


    /*유저 정보 조회 컨트롤러
    param : 조회 유저 UserId*/
    @GetMapping("/{userId}")
    public ResponseFormat<UserResDTO.READ> getUserByUserId(@PathVariable(name = "userId") Long userId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, userService.getUserByUserId(userId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*유저 정보 수정 컨트롤러
    param : 수정 유저 UserId, 수정 유저 info*/
    @PutMapping("/{userId}")
    public ResponseFormat<Void> updateUserByUserId(@PathVariable(name = "userId") Long userId,@RequestBody @Validated UserReqDTO.UPDATE update) {
        try {
            userService.updateUser(userId, update);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (DuplicatedException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*유저 삭제 컨트롤러
    param : 삭제 유저 UserId*/
    @DeleteMapping("/{userId}")
    public ResponseFormat<Void> deleteUserByUserId(@PathVariable(name = "userId") Long userId) {
        try {
            userService.deleteUserByUserId(userId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
