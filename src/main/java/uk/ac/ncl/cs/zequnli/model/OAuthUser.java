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

    private String name;
    private String username;
    private String userId;
    private String gender;
    private String page;

    public String getGender() {
        return gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = "https://www.facebook.com/"+page;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


