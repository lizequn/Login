package uk.ac.ncl.cs.zequnli.controller;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.Util.Util;
import uk.ac.ncl.cs.zequnli.interceptor.AppContext;
import uk.ac.ncl.cs.zequnli.interceptor.Identity;
import uk.ac.ncl.cs.zequnli.interceptor.Login;
import uk.ac.ncl.cs.zequnli.model.OAuthUser;
import uk.ac.ncl.cs.zequnli.model.UserType;
import uk.ac.ncl.cs.zequnli.service.OAuthUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
* @Auther: Li Zequn
* Date: 05/12/13
*/
@Controller
public class OAuthController {

    @Autowired
    OAuthUserService oAuthUserService;

    @RequestMapping(value = "loginFaceBook.do")
    public ModelAndView loginByFaceBook(HttpServletRequest request,HttpServletResponse response){
        OAuthClientRequest request1;
        try {
            request1 = OAuthClientRequest.authorizationProvider(OAuthProviderType.FACEBOOK)
                    .setClientId(Util.getClientId())
                    .setRedirectURI(Util.getRedirectUrl())
                    .buildQueryMessage();
        } catch (OAuthSystemException e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
        return new ModelAndView("redirect:"+request1.getLocationUri());

    }

    @RequestMapping(value = "getOauth.do")
    public ModelAndView accessFaceBook(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session){
        OAuthAuthzResponse oar;
        OAuthClientRequest request1;
        try {
            oar = OAuthAuthzResponse.oauthCodeAuthzResponse(request);
            request1 = OAuthClientRequest.tokenProvider(OAuthProviderType.FACEBOOK)
                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId(Util.getClientId())
                    .setClientSecret(Util.getClientSecret())
                    .setRedirectURI(Util.getRedirectUrl())
                    .setCode(oar.getCode())
                    .buildQueryMessage();
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

            GitHubTokenResponse gitHubTokenResponse = oAuthClient.accessToken(request1, GitHubTokenResponse.class);
            String accessToken = gitHubTokenResponse.getAccessToken();
            OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest("https://graph.facebook.com/me").setAccessToken(accessToken).buildQueryMessage();
//            OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest("https://graph.facebook.com/home").setAccessToken(accessToken).buildQueryMessage();
            OAuthResourceResponse resourceResponse = oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);

            if(! (200 ==resourceResponse.getResponseCode())){
                model.addAttribute("message",resourceResponse.getResponseCode());
                return new ModelAndView("error");
            }
//            model.addAttribute("message",resourceResponse.getBody());
            JSONObject jsonObject = (JSONObject)new JSONParser().parse(resourceResponse.getBody());
            String username = (String) jsonObject.get("username");
            String userId = (String) jsonObject.get("id");
            String name = (String) jsonObject.get("name");
            String gender = (String)jsonObject.get("gender");

            OAuthUser user =
            oAuthUserService.saveUser(username,name,userId,gender);
            System.out.println(user);
            model.addAttribute("message","UserName:"+username+" UserId:"+userId+" Name,"+name);
            Identity identity = new Identity(user.getUsername(),UserType.FaceBook);
            AppContext.getInstance().CheckAdd(identity,request.getSession());
            request.getSession().setAttribute("login",user);
            request.getSession().setAttribute("type", UserType.FaceBook);

            return new ModelAndView("oauthSuccess");
        } catch (OAuthProblemException e) {
            e.printStackTrace();
            return new ModelAndView("error");
        } catch (OAuthSystemException e) {
            e.printStackTrace();
            return  new ModelAndView("error");
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return new ModelAndView("error");
    }


}
