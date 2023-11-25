package org.sopkathon.www.DoSoptSopkathon.user.controller.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.Gender;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;

@Builder(access = AccessLevel.PRIVATE)
public record CreateUserRequestDto(
        Long id,
        String name,
        String birthday,
        Gender gender
) {
    public static CreateUserRequestDto of(User user){
        return CreateUserRequestDto.builder()
                .id(user.getId())
                .name(user.getName())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .build();

    }
}
