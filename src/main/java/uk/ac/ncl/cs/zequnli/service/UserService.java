package uk.ac.ncl.cs.zequnli.service;

import uk.ac.ncl.cs.zequnli.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    boolean checkUser(User user);
    boolean userExist(String username);
    List<User> getAllUsers();
    void linkUser(User user,String userId);
}
