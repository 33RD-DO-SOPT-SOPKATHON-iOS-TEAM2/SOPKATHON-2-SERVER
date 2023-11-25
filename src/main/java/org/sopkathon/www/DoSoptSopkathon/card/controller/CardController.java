package org.sopkathon.www.DoSoptSopkathon.card.controller;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.card.controller.dto.CreateCardRequestDto;
import org.sopkathon.www.DoSoptSopkathon.card.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/card")
@RestController
public class CardController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<Void> createCard(@RequestHeader(CUSTOM_AUTH_ID) Long userId,
                                           @RequestBody CreateCardRequestDto requestDto) {

        cardService.createCard(userId, requestDto);
        return ResponseEntity.noContent().build();
    }

}
