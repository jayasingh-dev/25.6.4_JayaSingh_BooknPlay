package com.codewithprojects.springsecurity.controller;

import com.codewithprojects.springsecurity.dto.TurfRequestDto;
import com.codewithprojects.springsecurity.dto.TurfResponseDto;
import com.codewithprojects.springsecurity.services.TurfService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turfs")
@RequiredArgsConstructor
public class TurfController {

    private static final Logger logger = LoggerFactory.getLogger(TurfController.class);

    private final TurfService turfService;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping
    public ResponseEntity<TurfResponseDto> addTurf(@Valid @RequestBody TurfRequestDto turfRequestDto, Authentication authentication) {
        String username = authentication.getName();
        logger.info("Turf add requested by user: {}", username);
        TurfResponseDto responseDTO = turfService.createTurfForOwner(turfRequestDto, username);
        return ResponseEntity.ok(responseDTO);
    }

    @PreAuthorize("hasRole('OWNER')")
    @PutMapping("/{id}")
    public ResponseEntity<TurfResponseDto> updateTurf( @Valid @PathVariable Long id, @RequestBody TurfRequestDto turfRequestDto, Authentication authentication) {
        String username = authentication.getName();
        TurfResponseDto responseDTO = turfService.updateTurfForOwner(id, turfRequestDto, username);
        return ResponseEntity.ok(responseDTO);
    }

    @PreAuthorize("hasRole('OWNER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurf(@PathVariable Long id, Authentication authentication) {
        String username = authentication.getName();
        turfService.deleteTurfForOwner(id, username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TurfResponseDto>> getAllTurfs() {
        return ResponseEntity.ok(turfService.getAllTurfs());
    }
}


