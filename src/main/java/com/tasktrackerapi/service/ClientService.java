package com.tasktrackerapi.service;

import com.tasktrackerapi.dto.ClientRegisterDTO;

public interface ClientService {
    void registerClient(ClientRegisterDTO clientRegisterDTO);
}
