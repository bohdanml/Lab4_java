package org.example.hotel.repository;

import org.example.hotel.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> dtoList = new ArrayList<>();
    private static long ID = 1;

    public User getUserById(long id) {
        return dtoList.stream()
                .filter(dto -> dto.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such user"));
    }

    public List<User> getUsers() {
        return dtoList;
    }

    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(ID);
            dtoList.add(user);
            ++ID;
        } else {
            User existingUser = getUserById(user.getId());
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
        }
        return user;
    }

    public void deleteById(long id) {
        dtoList.removeIf(dto -> dto.getId() == id);
    }
}
