package org.sopkathon.www.DoSoptSopkathon.user.controller;

import lombok.RequiredArgsConstructor;
import org.sopkathon.www.DoSoptSopkathon.user.controller.dto.request.CreateUserRequest;
import org.sopkathon.www.DoSoptSopkathon.user.domain.entity.User;
import org.sopkathon.www.DoSoptSopkathon.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping
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
