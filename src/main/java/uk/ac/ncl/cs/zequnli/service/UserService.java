package uk.ac.ncl.cs.zequnli.service;

import uk.ac.ncl.cs.zequnli.model.User;

public interface UserService {
    void saveUser(User user);
    boolean checkUser(User user);
    boolean userExist(String username);
}
