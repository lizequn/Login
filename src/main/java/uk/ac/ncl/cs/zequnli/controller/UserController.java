package uk.ac.ncl.cs.zequnli.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.model.User;
import uk.ac.ncl.cs.zequnli.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodType;


@Controller
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping("login.do")
    public String loginCon(Model model){
       model.addAttribute("user",new User());
       return "login";
    }
    @RequestMapping("register.do")
    public String registerCon(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "registerPro.do" , method = RequestMethod.POST)
    public ModelAndView registerMethod(Model model,@ModelAttribute("user") User user, BindingResult result){
        if(userservice.userExist(user.getUsername())){
            model.addAttribute("message","user already exist");
            return new ModelAndView("login");
        }
        userservice.saveUser(user);
        model.addAttribute("message","register success");
        return new ModelAndView("success");
    }

    @RequestMapping(value = "loginPro.do" , method = RequestMethod.POST)
    public ModelAndView loginMethod(Model model, @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request){
        if(userservice.checkUser(user)){
            request.getSession().setAttribute("login",user.getId());
            model.addAttribute("message","login success");
            return new ModelAndView("success");
        }
        model.addAttribute("message","login failed");
        return new ModelAndView("login");
    }
}
