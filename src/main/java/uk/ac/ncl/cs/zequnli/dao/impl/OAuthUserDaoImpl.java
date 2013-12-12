package uk.ac.ncl.cs.zequnli.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.dao.OAuthUserDao;
import uk.ac.ncl.cs.zequnli.model.OAuthUser;

/**
 * @Auther: Li Zequn
 * Date: 07/12/13
 */
@Repository
public class OAuthUserDaoImpl extends HibernateDaoSupport implements OAuthUserDao {
    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    public boolean checkExist(String userId) {
        return !getHibernateTemplate().find("from OAuthUser u where u.userId = ?",userId).isEmpty();
    }

    public OAuthUser getInfoByName(String username) {
        OAuthUser user =(OAuthUser)getHibernateTemplate().find("from OAuthUser u where u.username = ?",username).get(0);
        return user;
    }

    public void register(OAuthUser user) {
        if(!checkExist(user.getUserId())){
            getHibernateTemplate().persist(user);
        } else {
            OAuthUser old = (OAuthUser)getHibernateTemplate().find("from OAuthUser u where u.userId = ?",user.getUserId()).get(0);
            user.setId(old.getId());
            getHibernateTemplate().update(user);
        }
    }
}
