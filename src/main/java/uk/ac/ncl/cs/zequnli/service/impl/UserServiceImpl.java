package uk.ac.ncl.cs.zequnli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.ncl.cs.zequnli.dao.UserDao;
import uk.ac.ncl.cs.zequnli.model.User;
import uk.ac.ncl.cs.zequnli.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;
    @Override
    public void saveUser(User user) {
        userdao.createUser(user);

    }

    @Override
    public boolean checkUser(User user) {
      return userdao.getUser(user);
    }
    @Override
    public boolean userExist(String username) {
        return userdao.checkExist(username);
    }
    @Override
    public List<User> getAllUsers() {
        return userdao.getAllUsers();
    }

    public void linkUser(User user, String userId) {
        userdao.linkUser(user,userId);
    }
}
