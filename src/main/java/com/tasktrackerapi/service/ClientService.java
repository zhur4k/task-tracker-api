package com.tasktrackerapi.service;

import com.tasktrackerapi.dto.ClientRegisterDTO;
import com.tasktrackerapi.dto.ClientUpdateDTO;
import com.tasktrackerapi.model.Client;

public interface ClientService {
    void registerClient(ClientRegisterDTO clientRegisterDTO);

    void updateClient(ClientUpdateDTO clientUpdateDTO, Client client);
}
