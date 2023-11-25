package org.sopkathon.www.DoSoptSopkathon.card.service;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.card.controller.dto.GetSharedCardResponse;
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

    public List<GetSharedCardResponse> getSharedCards() {
        List<Card> cards = cardRepository.findAll();
        List<GetSharedCardResponse> responses = cards.stream()
                .map(card -> {
                    return GetSharedCardResponse.of(card.getUser(), card);
                })
                .toList();

        return responses;
    }


}
