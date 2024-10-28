package com.tasktrackerapi.service.impl;

import com.tasktrackerapi.dto.RecordGetDTO;
import com.tasktrackerapi.dto.mapper.RecordGetDTOMapper;
import com.tasktrackerapi.model.Client;
import com.tasktrackerapi.model.Project;
import com.tasktrackerapi.model.Record;
import com.tasktrackerapi.repository.ProjectRepository;
import com.tasktrackerapi.repository.RecordRepository;
import com.tasktrackerapi.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    private final ProjectRepository projectRepository;

    private final RecordGetDTOMapper recordGetDTOMapper;

    @Override
    public void startRecord(Long projectId, Client client) {
        Record record = new Record();
        Project project = projectRepository.findById(projectId)
                        .orElseThrow(() -> new IllegalArgumentException("Project not found with ID: " + projectId));
        record.setProject(project);
        record.setStartTime(LocalDateTime.now());
        record.setClient(client);
        recordRepository.save(record);
    }

    @Override
    public void endRecord(Long projectId, Client client) {
        Record record = recordRepository.findByProjectIdAndClient(projectId, client)
                .orElseThrow(() -> new IllegalArgumentException("Record not found with project ID: " + projectId));
        record.setEndTime(LocalDateTime.now());
        recordRepository.save(record);
    }

    @Override
    public void deleteRecord(Long recordId) {
        if(recordRepository.existsById(recordId)){
            recordRepository.deleteById(recordId);
        }
        else{
            throw new IllegalArgumentException("Record not found with ID: " + recordId);
        }
    }

    @Override
    public List<RecordGetDTO> getAllRecords() {
        return recordRepository.findAll()
                .stream()
                .map(recordGetDTOMapper)
                .collect(Collectors.toList());
    }
}
