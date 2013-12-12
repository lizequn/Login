package uk.ac.ncl.cs.zequnli.service;

import uk.ac.ncl.cs.zequnli.dao.OAuthUserDao;
import uk.ac.ncl.cs.zequnli.model.OAuthUser;
import uk.ac.ncl.cs.zequnli.model.User;

import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 07/12/13
 */
public interface OAuthUserService {
    OAuthUser saveUser(OAuthUser user);
    OAuthUser saveUser(String username,String name,String userId,String gender);
    OAuthUser getUserByName(String name);

}
