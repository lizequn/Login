package uk.ac.ncl.cs.zequnli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ncl.cs.zequnli.dao.OAuthUserDao;
import uk.ac.ncl.cs.zequnli.model.OAuthUser;
import uk.ac.ncl.cs.zequnli.service.OAuthUserService;

import java.util.List;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
@Service
public class OAuthUserServiceImpl implements OAuthUserService {
    @Autowired
    private OAuthUserDao oAuthUser;

    public OAuthUser getUserByName(String name) {
        return oAuthUser.getInfoByName(name);
    }

    public OAuthUser saveUser(String username, String name, String userId, String gender) {
        OAuthUser oAuthUser1 = new OAuthUser();
        oAuthUser1.setUsername(username);
        oAuthUser1.setName(name);
        oAuthUser1.setUserId(userId);
        oAuthUser1.setGender(gender);
        oAuthUser1.setPage(username);
        oAuthUser.register(oAuthUser1);
        return oAuthUser1;
    }

    public OAuthUser saveUser(OAuthUser user) {
        oAuthUser.register(user);
        return user;
    }
}
