package com.saad.monolithicproject.mapper;

import com.saad.monolithicproject.dto.request.UserSaveRequestDto;
import com.saad.monolithicproject.dto.response.UserFindByIdResponseDto;
import com.saad.monolithicproject.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserSaveRequestDto toUserSaveRequestDto(final User user);
    User toUser(final UserFindByIdResponseDto dto);
    User toUser(final UserSaveRequestDto dto);
}
