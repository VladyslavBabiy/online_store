package ua.babiy.online_store.service;



import ua.babiy.online_store.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean saveNewUser(User user);
    List<User> findAll();
    Optional<User> findById(Long userId);
    void delete(User user);
    void blockUser(Long userId);
    void unblockUser(Long userId);
    void updateUser(User user, String firstName, String lastName, String password);
}
