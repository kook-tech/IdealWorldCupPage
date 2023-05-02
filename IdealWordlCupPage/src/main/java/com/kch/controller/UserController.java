package com.kch.controller;

import com.kch.infrastructure.error.DuplicatedException;
import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.User;
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

    @PostMapping
    public ResponseFormat<Void> createUser(@RequestParam @Validated UserReqDTO.CREATE create){
        try {
            userService.createUser(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (DuplicatedException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_EMAIL_DUPLICATED);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}")
    public ResponseFormat<UserResDTO.READ> getUserByUserId(@PathVariable(name="userId") Long userId){
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, userService.getUserByUserId(userId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}
