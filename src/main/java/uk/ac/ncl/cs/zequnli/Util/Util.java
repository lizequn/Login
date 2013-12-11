package uk.ac.ncl.cs.zequnli.Util;

/**
 * @Auther: Li Zequn
 * Date: 03/12/13
 */
public class Util {
//    private final static String clientId = "223283651290.apps.googleusercontent.com";
//    private final static String clientSecret = "lp3SDksMkQ0Vd40NUBjqXpkO";
    private final static String clientId = "245657068926997";
    private final static String clientSecret = "3b7d22ecccb0299fd6a89392a8bfabb3";
    private final static String redirectUrl = "http://localhost:8080/getOauth.do";



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
