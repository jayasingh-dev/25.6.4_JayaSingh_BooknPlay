package com.codewithprojects.springsecurity.controller;

import com.codewithprojects.springsecurity.dto.SlotRequestDto;
import com.codewithprojects.springsecurity.dto.SlotResponseDto;
import com.codewithprojects.springsecurity.services.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/slots")
@RequiredArgsConstructor
public class SlotController {
    private final SlotService slotService;

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping
    public ResponseEntity<SlotResponseDto> addSlot(@RequestBody SlotRequestDto slotRequestDto, Authentication authentication) {
        String username = authentication.getName();
        SlotResponseDto responseDTO = slotService.createSlotForOwner(slotRequestDto, username);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/turf/{turfId}")
    public ResponseEntity<List<SlotResponseDto>> getSlotsForTurf(@PathVariable Long turfId) {
        return ResponseEntity.ok(slotService.getSlotsForTurf(turfId));
    }
}

