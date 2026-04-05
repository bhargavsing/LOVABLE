package com.MAJORPROJECT.LOVABLE.mapper;

import com.MAJORPROJECT.LOVABLE.dto.auth.SignUpRequest;
import com.MAJORPROJECT.LOVABLE.dto.auth.UserProfileResponse;
import com.MAJORPROJECT.LOVABLE.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.control.MappingControl;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequest signUpRequest);
    UserProfileResponse toUserProfileResponse(User user);

}
