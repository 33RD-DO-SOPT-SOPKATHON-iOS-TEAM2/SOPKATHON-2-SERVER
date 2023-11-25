package org.sopkathon.www.DoSoptSopkathon.card.controller.dto;

import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Alcohol;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.DressCode;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Flower;

public record CreateCardRequestDto(
        Flower flower,
        Alcohol alcohol,
        DressCode dressCode,
        String music,
        String scent
) {
}
