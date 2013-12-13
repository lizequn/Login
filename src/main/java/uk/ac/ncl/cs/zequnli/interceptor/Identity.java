package uk.ac.ncl.cs.zequnli.interceptor;

import uk.ac.ncl.cs.zequnli.model.UserType;

/**
 * @Auther: Li Zequn
 * Date: 13/12/13
 */
public class Identity {
    private UserType userType;
    private String username;

    public Identity(String username, UserType userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity)) return false;

        Identity identity = (Identity) o;

        if (userType != identity.userType) return false;
        if (username != null ? !username.equals(identity.username) : identity.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userType != null ? userType.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
