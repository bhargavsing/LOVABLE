package com.MAJORPROJECT.LOVABLE.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Getter
public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String resourceId;
}
