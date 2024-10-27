package com.tasktrackerapi.controller;

import com.tasktrackerapi.dto.ClientRegisterDTO;
import com.tasktrackerapi.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final ClientService clientService;

    @Operation(summary = "Register a new client", description = "Register a new client by providing the necessary details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client registered successfully"),
            @ApiResponse(responseCode = "409", description = "Client with this login already exists",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestBody ClientRegisterDTO clientRegisterDTO) {
        clientService.registerClient(clientRegisterDTO);
        return ResponseEntity.ok("Client registered successfully");
    }
}
