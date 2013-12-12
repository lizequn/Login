//package uk.ac.ncl.cs.zequnli.controller;
//
//import org.apache.oltu.oauth2.client.OAuthClient;
//import org.apache.oltu.oauth2.client.URLConnectionClient;
//import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
//import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
//import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
//import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
//import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
//import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
//import org.apache.oltu.oauth2.common.OAuth;
//import org.apache.oltu.oauth2.common.OAuthProviderType;
//import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
//import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
//import org.apache.oltu.oauth2.common.message.types.GrantType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import uk.ac.ncl.cs.zequnli.Util.Util;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
//* @Auther: Li Zequn
//* Date: 05/12/13
//*/
//@Controller
//public class OAuthController1 {
//    @RequestMapping(value = "loginGoogle.do")
//    public ModelAndView loginByGoogle(HttpServletRequest request,HttpServletResponse response){
//        OAuthClientRequest request1;
//        try {
//            request1 = OAuthClientRequest.authorizationProvider(OAuthProviderType.GOOGLE)
//                    .setClientId(Util.getClientId())
//                    .setRedirectURI(Util.getRedirectUrl())
//                    .setResponseType("code")
//                    .setScope("openid email")
//                    .buildQueryMessage();
//        } catch (OAuthSystemException e) {
//            e.printStackTrace();
//            return new ModelAndView("error");
//        }
//        return new ModelAndView("redirect:"+request1.getLocationUri());
//
//    }
//
//    @RequestMapping(value = "getOauth.do")
//    public ModelAndView accessGoogle(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session){
//        OAuthAuthzResponse oar;
//        OAuthClientRequest request1;
//        try {
//            oar = OAuthAuthzResponse.oauthCodeAuthzResponse(request);
//            request1 = OAuthClientRequest.tokenProvider(OAuthProviderType.GOOGLE)
//                    .setGrantType(GrantType.AUTHORIZATION_CODE)
//                    .setClientId(Util.getClientId())
//                    .setClientSecret(Util.getClientSecret())
//                    .setRedirectURI(Util.getRedirectUrl())
//                    .setCode(oar.getCode())
//                    .buildBodyMessage();
//            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
//            //error
//            OAuthJSONAccessTokenResponse oAuthJSONAccessTokenResponse = oAuthClient.accessToken(request1, OAuthJSONAccessTokenResponse.class);
//            String accessToken = oAuthJSONAccessTokenResponse.getAccessToken();
//            // OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest("https://plus.google.com/").setAccessToken(accessToken).buildQueryMessage();
//            // OAuthResourceResponse resourceResponse = oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
//            // model.addAttribute("code",resourceResponse.getResponseCode());
//            // model.addAttribute("message",resourceResponse.getBody());
//            model.addAttribute("message",accessToken);
//            return new ModelAndView("oauthSuccess");
//        } catch (OAuthProblemException e) {
//            e.printStackTrace();
//            return new ModelAndView("error");
//        } catch (OAuthSystemException e) {
//            e.printStackTrace();
//            return  new ModelAndView("error");
//        }
//    }
//
//
//}
