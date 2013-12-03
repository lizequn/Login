package uk.ac.ncl.cs.zequnli.dao.impl;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.dao.UserDao;
import uk.ac.ncl.cs.zequnli.model.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void createUser(User user) {
        getHibernateTemplate().persist(user);
    }

    @Override
    public boolean getUser(User user) {
          return !getHibernateTemplate().findByExample(user).isEmpty();
    }
}
