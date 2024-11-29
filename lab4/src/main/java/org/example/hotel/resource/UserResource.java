package org.example.hotel.resource;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.UserDTO;
import org.example.hotel.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserResource {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO UserDTO) {

        return userService.createUser(UserDTO);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO UserDTO) {
        return userService.updateUser(UserDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }
}

