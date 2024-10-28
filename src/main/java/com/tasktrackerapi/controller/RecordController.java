package com.tasktrackerapi.controller;

import com.tasktrackerapi.dto.RecordGetDTO;
import com.tasktrackerapi.model.User;
import com.tasktrackerapi.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/record")
public class RecordController {

    private final RecordService recordService;

    @Operation(summary = "Get all records", description = "Retrieve all records.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Records retrieved successfully",
                    content = @Content(schema = @Schema(implementation = RecordGetDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/all")
    public ResponseEntity<List<RecordGetDTO>> getAllRecords() {
        List<RecordGetDTO> records = recordService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @Operation(summary = "Start a new record", description = "Start a new record.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Record start successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid project id",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("start/{projectId}")
    public ResponseEntity<String> startRecord(@PathVariable Long projectId, @AuthenticationPrincipal UserDetails userDetails) {
        recordService.startRecord(projectId, ((User) userDetails).getClient());
        return ResponseEntity.status(HttpStatus.CREATED).body("Record started successfully");
    }

    @Operation(summary = "End record", description = "End record.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Record end successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid project id",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("end/{projectId}")
    public ResponseEntity<String> endRecord(@PathVariable Long projectId, @AuthenticationPrincipal UserDetails userDetails) {
        recordService.endRecord(projectId, ((User) userDetails).getClient());
        return ResponseEntity.status(HttpStatus.CREATED).body("Record ended successfully");
    }

    @Operation(summary = "Delete a record", description = "Delete a record by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Record deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Record not found",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully");
    }
}
