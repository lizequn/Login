package uk.ac.ncl.cs.zequnli.dao;


import uk.ac.ncl.cs.zequnli.model.User;

public interface UserDao {
    void createUser(User user);
    boolean getUser(User user);
}
