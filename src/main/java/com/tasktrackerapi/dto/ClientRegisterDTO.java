package com.tasktrackerapi.dto;

import com.tasktrackerapi.model.Role;

public record ClientRegisterDTO(

    String username,

    String password,

    String firstName,

    String lastNAme,

    Role role
) {
}
