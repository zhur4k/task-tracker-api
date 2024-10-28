package com.tasktrackerapi.dto;

import java.time.LocalDateTime;

public record RecordAddDTO(

        LocalDateTime startTime,

        LocalDateTime endTime,

        Long projectId
) {
}
