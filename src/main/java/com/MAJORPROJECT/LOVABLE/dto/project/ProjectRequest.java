package com.MAJORPROJECT.LOVABLE.dto.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
       @NotBlank String name ) {

}
