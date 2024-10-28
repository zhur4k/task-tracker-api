package com.tasktrackerapi.service.impl;

import com.tasktrackerapi.dto.ClientRegisterDTO;
import com.tasktrackerapi.dto.ClientUpdateDTO;
import com.tasktrackerapi.model.Client;
import com.tasktrackerapi.model.Role;
import com.tasktrackerapi.model.User;
import com.tasktrackerapi.repository.ClientRepository;
import com.tasktrackerapi.repository.UserRepository;
import com.tasktrackerapi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void registerClient(ClientRegisterDTO clientRegisterDTO) {
        if (userRepository.findByUsername(clientRegisterDTO.username()).isPresent()) {
            throw new IllegalArgumentException("User with this login already exists");
        }

        Client client = new Client();
        client.setFirstName(clientRegisterDTO.firstName());
        client.setLastName(clientRegisterDTO.lastNAme());

        clientRepository.save(client);

        User user = new User();
        user.setUsername(clientRegisterDTO.username());
        user.setPassword(passwordEncoder.encode(clientRegisterDTO.password()));
        user.setClient(client);
        user.setIsEnabled(true);
        user.setRoles(Set.of(clientRegisterDTO.role() == null ? Role.USER : clientRegisterDTO.role()));
        userRepository.save(user);
    }

    @Override
    public void updateClient(ClientUpdateDTO clientUpdateDTO, Client client) {
        client.setFirstName(clientUpdateDTO.firstName());
        client.setLastName(client.getLastName());

        clientRepository.save(client);
    }
}
