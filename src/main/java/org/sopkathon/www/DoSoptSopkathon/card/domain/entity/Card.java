package org.sopkathon.www.DoSoptSopkathon.card.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.common.domain.entity.BaseCreatedTimeEntity;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Card extends BaseCreatedTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Flower flower;

    @Enumerated(value = EnumType.STRING)
    private Alcohol alcohol;

    @Enumerated(value = EnumType.STRING)
    private DressCode dressCode;

    private String music;

    private String scent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Card(Flower flower, Alcohol alcohol, DressCode dressCode, String music, String scent, User user) {
        this.alcohol = alcohol;
        this.flower = flower;
        this.dressCode = dressCode;
        this.user = user;
        this.music = music;
        this.scent = scent;
    }
}
