package org.example.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotel.dto.UserDTO;
import org.example.hotel.entity.User;
import org.example.hotel.repository.UserRepository;
import org.example.hotel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository.getUserById(id);
        return UserDTO.fromUser(user);
    }

    @Override

    public List<UserDTO> getUsers() {
        return userRepository.getUsers().stream()
                .map(e -> UserDTO.fromUser(e))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(final UserDTO userDTO) {
        final User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return UserDTO.fromUser(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.getUserById(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return UserDTO.fromUser(user);
    }

    @Override

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}
