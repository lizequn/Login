package uk.ac.ncl.cs.zequnli.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.dao.UserDao;
import uk.ac.ncl.cs.zequnli.model.User;

import java.util.List;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    @Override
    public void createUser(User user) {
        getHibernateTemplate().persist(user);
    }

    @Override
    public boolean getUser(User user) {
          return !getHibernateTemplate().findByExample(user).isEmpty();
    }
    @Override
    public boolean checkExist(String username) {
        String [] s = new String[1];
        s[0] = username;
        return !getHibernateTemplate().find("from User u where u.username = ?",s).isEmpty();
    }

    public void linkUser(User user ,String userId) {
       user.setFaceBookId(userId);
        getHibernateTemplate().update(user);
    }

    @Override
    public List<User> getAllUsers(){
        List<User> list = (List<User>)getHibernateTemplate().find("from User ");
        return list;
    }
}
