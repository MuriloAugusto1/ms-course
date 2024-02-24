package io.github.muriloaugusto1.hroauth.resources;

import io.github.muriloaugusto1.hroauth.entities.User;
import io.github.muriloaugusto1.hroauth.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) throws IllegalAccessException {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
