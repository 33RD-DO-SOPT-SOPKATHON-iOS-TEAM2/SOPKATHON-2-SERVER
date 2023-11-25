package org.sopkathon.www.DoSoptSopkathon.card.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.card.controller.dto.request.CreateCardRequestDto;
import org.sopkathon.www.DoSoptSopkathon.card.controller.dto.response.GetCardResponseDto;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Card;
import org.sopkathon.www.DoSoptSopkathon.card.domain.repository.CardRepository;
import org.sopkathon.www.DoSoptSopkathon.card.exception.CardException;
import org.sopkathon.www.DoSoptSopkathon.card.exception.CardExceptionType;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;
import org.sopkathon.www.DoSoptSopkathon.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createCard(Long userId, CreateCardRequestDto requestDto) {
        User user = userRepository.findByIdOrElseThrowException(userId);
        Optional<Card> existedCard = cardRepository.findByUserId(user.getId());

        if (existedCard.isPresent()) {
            throw new CardException(CardExceptionType.ALREADY_CREATED_CARD);
        }

        Card card = Card.builder()
                .flower(requestDto.flower())
                .alcohol(requestDto.alcohol())
                .dressCode(requestDto.dressCode())
                .music(requestDto.music())
                .scent(requestDto.scent())
                .user(user)
                .build();

        cardRepository.save(card);
    }

    public GetCardResponseDto getCardByUser(Long userId) {
        User user = userRepository.findByIdOrElseThrowException(userId);
        Card card = cardRepository.getCardByUserOrElseThrowException(user.getId());

        return GetCardResponseDto.of(user, card);
    }
}
