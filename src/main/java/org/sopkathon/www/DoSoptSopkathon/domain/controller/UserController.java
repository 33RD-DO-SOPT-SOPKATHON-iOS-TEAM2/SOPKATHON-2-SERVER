package org.sopkathon.www.DoSoptSopkathon.domain.controller;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.domain.controller.dto.request.CreateUserRequest;
import org.sopkathon.www.DoSoptSopkathon.domain.domain.entity.User;
import org.sopkathon.www.DoSoptSopkathon.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody final CreateUserRequest request) {
        User createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }


}
