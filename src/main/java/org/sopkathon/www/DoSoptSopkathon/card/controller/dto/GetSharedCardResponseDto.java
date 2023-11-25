package org.sopkathon.www.DoSoptSopkathon.card.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Alcohol;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Card;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.DressCode;
import org.sopkathon.www.DoSoptSopkathon.card.domain.entity.Flower;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.Gender;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;

@Builder(access = AccessLevel.PRIVATE)
public record GetSharedCardResponseDto(
        String name,
        String birthday,
        Gender gender,
        Flower flower,
        Alcohol alcohol,
        DressCode dressCode,
        String music,
        String scent

) {
    public static GetSharedCardResponseDto of(User user, Card card) {
        return GetSharedCardResponseDto.builder()
                .name(user.getName())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .flower(card.getFlower())
                .alcohol(card.getAlcohol())
                .dressCode(card.getDressCode())
                .music(card.getMusic())
                .scent(card.getScent())
                .build();

    }

}
