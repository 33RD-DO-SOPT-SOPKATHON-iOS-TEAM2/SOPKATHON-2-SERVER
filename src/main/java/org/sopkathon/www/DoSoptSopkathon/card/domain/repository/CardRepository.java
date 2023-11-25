package org.sopkathon.www.DoSoptSopkathon.card.domain.repository;

import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Card;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CardRepository extends Repository<Card, Long> {

    void save(Card card);

    List<Card> findAll();

}
