package com.tasktrackerapi.repository;

import com.tasktrackerapi.model.Client;
import com.tasktrackerapi.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findByProjectIdAndClient(Long projectId, Client client);
}
