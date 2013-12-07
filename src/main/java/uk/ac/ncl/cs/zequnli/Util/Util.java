package uk.ac.ncl.cs.zequnli.Util;

/**
 * @Auther: Li Zequn
 * Date: 03/12/13
 */
public class Util {
    private final static String clientId = "223283651290.apps.googleusercontent.com";
    private final static String clientSecret = "lp3SDksMkQ0Vd40NUBjqXpkO";
    private final static String redirectUrl = "http://localhost:8080/getOauth.do";
    private final static String accessTokenUrl = "http://localhost:8080/getAccessToken.do";

    public static String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public static String getRedirectUrl() {
        return redirectUrl;
    }

    public static String getClientId() {
        return clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }
}
