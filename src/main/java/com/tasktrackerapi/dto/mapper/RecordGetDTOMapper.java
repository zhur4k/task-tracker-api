package com.tasktrackerapi.dto.mapper;

import com.tasktrackerapi.dto.RecordGetDTO;
import com.tasktrackerapi.model.Record;

import java.util.function.Function;

public class RecordGetDTOMapper implements Function<Record, RecordGetDTO> {

    @Override
    public RecordGetDTO apply(Record record) {
        return new RecordGetDTO(
                record.getDescription(),
                record.getStartTime(),
                record.getEndTime()
        );
    }
}
