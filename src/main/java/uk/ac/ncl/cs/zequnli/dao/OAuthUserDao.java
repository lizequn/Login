package uk.ac.ncl.cs.zequnli.dao;

import uk.ac.ncl.cs.zequnli.model.OAuthUser;

/**
 * @Auther: Li Zequn
 * Date: 07/12/13
 */
public interface OAuthUserDao {
    boolean checkExist(String username);
    OAuthUser getInfoByName(String username);
    void register(OAuthUser user);
}
