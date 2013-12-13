package uk.ac.ncl.cs.zequnli.interceptor;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Li Zequn
 * Date: 13/12/13
 */

public class AppContext {
    private static  Map<Identity,HttpSession> map;
    private static  AppContext ourInstance = new AppContext();

    public static AppContext getInstance() {
        return ourInstance;
    }

    private AppContext() {
        map = new HashMap<>();
        System.out.println("init");
    }
    public boolean CheckAdd(Identity identity,HttpSession session){
        System.out.println("do me");
        if(map.containsKey(identity)){
            HttpSession session1 = map.get(identity);
            session1.invalidate();
            map.remove(identity);
            System.out.println("destroy one");
        }
        System.out.println(identity.hashCode());
        System.out.println(map.size());
        map.put(identity,session);
        return true;
    }
}
