package com.kch.service.model.mapper;

import com.kch.persistence.entity.User;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.dtos.response.UserResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserEntity(UserReqDTO.CREATE create);
    UserResDTO.READ toReadDto(User user);
}
