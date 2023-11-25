package org.sopkathon.www.DoSoptSopkathon.card.domain.repository;

import java.util.Optional;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Card;
import org.sopkathon.www.DoSoptSopkathon.card.exception.CardException;
import org.sopkathon.www.DoSoptSopkathon.card.exception.CardExceptionType;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CardRepository extends Repository<Card, Long> {

    void save(Card card);
    List<Card> findAllByOrderByCreatedAtDesc();

    Optional<Card> findByUserId(Long userId);

    default Card getCardByUserOrElseThrowException(Long userId) {
        return findByUserId(userId).orElseThrow(() -> new CardException(CardExceptionType.NOT_FOUND_CARD));
    }
}
