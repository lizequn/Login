package uk.ac.ncl.cs.zequnli.dao;


import uk.ac.ncl.cs.zequnli.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    boolean getUser(User user);
    boolean checkExist(String username);
    void linkUser(User user,String userId);
    List<User> getAllUsers();
}
