package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.dto.SlotRequestDto;
import com.codewithprojects.springsecurity.dto.SlotResponseDto;
import com.codewithprojects.springsecurity.entities.Slot;
import com.codewithprojects.springsecurity.entities.Turf;
import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.exception.BookingException;
import com.codewithprojects.springsecurity.repository.SlotRepository;
import com.codewithprojects.springsecurity.repository.TurfRepository;
import com.codewithprojects.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlotService {
    private final SlotRepository slotRepository;
    private final TurfRepository turfRepository;
    private final UserRepository userRepository;

    public SlotResponseDto createSlotForOwner(SlotRequestDto request, String ownerEmail) {
        Turf turf = turfRepository.findById(request.getTurfId())
                .orElseThrow(() -> new BookingException("Turf not found"));
        if (!turf.getOwner().getEmail().equals(ownerEmail)) {
            throw new BookingException("Not your turf");
        }
        Slot slot = Slot.builder()
                .turf(turf)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .build();
        slotRepository.save(slot);
        return SlotResponseDto.fromEntity(slot);
    }

    public List<SlotResponseDto> getSlotsForTurf(Long turfId) {
        Turf turf = turfRepository.findById(turfId)
                .orElseThrow(() -> new BookingException("Turf not found"));
        return slotRepository.findByTurf(turf).stream()
                .map(SlotResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
