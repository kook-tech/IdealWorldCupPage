package com.kch.service.model.mapper;

import com.kch.persistence.entity.User;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.dtos.response.UserResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "loginId", source = "create.loginId")
    @Mapping(target = "password", source = "create.password")
    @Mapping(target = "name", source = "create.name")
    @Mapping(target = "birth", source = "create.birth")
    @Mapping(target = "email", source = "create.email")
    @Mapping(target = "role", source = "create.role")
    User toUserEntity(UserReqDTO.CREATE create);

    @Mapping(target = "loginId", source = "create.loginId")
    @Mapping(target = "password", source = "create.password")
    @Mapping(target = "name", source = "create.name")
    @Mapping(target = "birth", source = "create.birth")
    @Mapping(target = "email", source = "create.email")
    @Mapping(target = "role", source = "create.role")
    UserResDTO.READ toReadDto(User user);

}
