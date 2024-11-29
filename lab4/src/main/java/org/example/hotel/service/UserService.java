package org.example.hotel.service;

import org.example.hotel.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(long id);

    List<UserDTO> getUsers();

    UserDTO createUser(UserDTO UserDTO);

    UserDTO updateUser(UserDTO UserDTO);

    void deleteById(long id);
}
