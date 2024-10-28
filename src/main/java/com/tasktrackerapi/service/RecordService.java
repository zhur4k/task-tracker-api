package com.tasktrackerapi.service;

import com.tasktrackerapi.dto.RecordGetDTO;
import com.tasktrackerapi.model.Client;

import java.util.List;

public interface RecordService {

    void startRecord(Long projectId, Client client);

    void endRecord(Long projectId, Client client);

    void deleteRecord(Long recordId);

    List<RecordGetDTO> getAllRecords();
}
