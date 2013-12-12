package uk.ac.ncl.cs.zequnli.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
@Entity
public class Info {
    @Id
    @GeneratedValue
    private Long id;
    private String userInfo;
    private String Info;

    public Info(String userInfo, String info) {
        this.Info = info;
        this.userInfo = userInfo;
    }
    public Info(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
