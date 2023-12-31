package org.sopkathon.www.DoSoptSopkathon.user.service;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.user.controller.dto.request.CreateUserRequestDto;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;
import org.sopkathon.www.DoSoptSopkathon.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    public final UserRepository userRepository;

    @Transactional
    public User createUser(final CreateUserRequestDto request) {
        User user = userRepository.save(User.builder()
                .name(request.name())
                .birthday(request.birthday())
                .gender(request.gender())
                .build());
        return user;
    }
}