package uk.ac.ncl.cs.zequnli.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import uk.ac.ncl.cs.zequnli.dao.InfoDao;
import uk.ac.ncl.cs.zequnli.model.Info;

import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
@Repository
public class InfoDaoImpl extends HibernateDaoSupport implements InfoDao {
    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    public void addInfo(Info info) {
        getHibernateTemplate().persist(info);
    }

    public List<Info> getAll() {
        return (List<Info>)getHibernateTemplate().find("from Info");
    }
}
