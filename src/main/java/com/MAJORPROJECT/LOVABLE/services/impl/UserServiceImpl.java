package com.MAJORPROJECT.LOVABLE.services.impl;

import com.MAJORPROJECT.LOVABLE.dto.auth.UserProfileResponse;
import com.MAJORPROJECT.LOVABLE.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}


//CONTROLLERS -> SERVICES ->SERVICESIMPL ->(REPO)->DATABASE
//CONTROLLERS ->DEPENDS ON SERVICES ->  SERVICEIMPL(PROJECTMEMBERSERVICETEST implements particaluarService)
//ProjectMemberServicecacgeImpl ->implements particaularService
//INTERFACES