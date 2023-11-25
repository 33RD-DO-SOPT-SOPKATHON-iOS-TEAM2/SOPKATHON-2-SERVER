package org.sopkathon.www.DoSoptSopkathon.card.service;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.card.controller.dto.GetSharedCardResponseDto;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Card;
import org.sopkathon.www.DoSoptSopkathon.card.domain.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SharedCardService {
    private final CardRepository cardRepository;

    public List<GetSharedCardResponseDto> getSharedCards() {
        List<Card> cards = cardRepository.findAllByOrderByCreatedAtDesc();

        return cards.stream()
                .map(card -> {
                    return GetSharedCardResponseDto.of(card.getUser(), card);
                })
                .toList();

    }

}
