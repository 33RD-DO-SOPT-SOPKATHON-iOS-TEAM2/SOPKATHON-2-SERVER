package org.sopkathon.www.DoSoptSopkathon.card.controller;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.card.controller.dto.GetSharedCardResponseDto;
import org.sopkathon.www.DoSoptSopkathon.card.service.SharedCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shared-card")
public class SharedCardController {

    private final SharedCardService sharedCardService;
    @GetMapping
    public ResponseEntity<List<GetSharedCardResponseDto>> sharedCards() {
        return ResponseEntity.ok(sharedCardService.getSharedCards());
    }
}
