package com.tasktrackerapi.dto;

import java.time.LocalDateTime;

public record RecordGetDTO(

        String description,

        LocalDateTime startTime,

        LocalDateTime endTime
) {
}
