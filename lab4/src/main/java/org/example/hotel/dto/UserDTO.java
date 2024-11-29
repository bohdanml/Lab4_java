package org.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotel.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private String email;

    public static UserDTO fromUser(User user) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
