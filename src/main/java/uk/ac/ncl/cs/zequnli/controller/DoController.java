package uk.ac.ncl.cs.zequnli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.interceptor.Login;
import uk.ac.ncl.cs.zequnli.model.Info;
import uk.ac.ncl.cs.zequnli.model.OAuthUser;
import uk.ac.ncl.cs.zequnli.model.User;
import uk.ac.ncl.cs.zequnli.model.UserType;
import uk.ac.ncl.cs.zequnli.service.InfoService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Li Zequn
 * Date: 12/12/13
 */
@Controller
public class DoController {
    @Autowired
    InfoService infoService;
    @Login
    @RequestMapping(value = "Info.do")
    public String getInfo(Model model){
        model.addAttribute("info",infoService.getAllInfo());
        return "Info";
    }

    @Login
    @RequestMapping(value = "addInfo.do",method = RequestMethod.POST)
    public String addInfo(HttpServletRequest request,Model model){
        UserType type = (UserType)request.getSession().getAttribute("type");
        StringBuilder userInfo = new StringBuilder();
        if(type.equals(UserType.Normal)){
            User user = (User)request.getSession().getAttribute("login");
            userInfo.append("Normal User---UserName:"+user.getUsername());
        }else {
            OAuthUser user = (OAuthUser)request.getSession().getAttribute("login");
            userInfo.append("FaceBook User---Name:"+user.getName()+" UserName:"+user.getUsername());
        }
        String info = request.getParameter("addInfo");
        infoService.addInfo(new Info(userInfo.toString(),info));
        model.addAttribute("info",infoService.getAllInfo());
        return "Info";
    }

}
