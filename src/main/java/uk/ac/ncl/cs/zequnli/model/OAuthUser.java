package uk.ac.ncl.cs.zequnli.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: Li Zequn
 * Date: 07/12/13
 */

@Entity
public class OAuthUser {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String info;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


