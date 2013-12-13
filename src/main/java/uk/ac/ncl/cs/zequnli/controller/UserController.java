package uk.ac.ncl.cs.zequnli.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.ncl.cs.zequnli.interceptor.AppContext;
import uk.ac.ncl.cs.zequnli.interceptor.Identity;
import uk.ac.ncl.cs.zequnli.interceptor.Login;
import uk.ac.ncl.cs.zequnli.model.User;
import uk.ac.ncl.cs.zequnli.model.UserType;
import uk.ac.ncl.cs.zequnli.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.invoke.MethodType;
import java.util.List;


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
    public ModelAndView registerMethod(Model model,@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for(ObjectError oe:result.getAllErrors()){
                sb.append(oe.getDefaultMessage());
                sb.append("     ");
            }
            model.addAttribute("message",sb.toString());
            return new ModelAndView("login");
        }

        if(userservice.userExist(user.getUsername())){
            model.addAttribute("message","user already exist");
            return new ModelAndView("login");
        }
        userservice.saveUser(user);
        model.addAttribute("message","register success");
        return new ModelAndView("success");
    }

    @RequestMapping(value = "loginPro.do" , method = RequestMethod.POST)
    public ModelAndView loginMethod(Model model, @Valid @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request){
        if(result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for(ObjectError oe:result.getAllErrors()){
                sb.append(oe.getDefaultMessage());
                sb.append("     ");
            }
            model.addAttribute("message",sb.toString());
            return new ModelAndView("login");
        }
        if(userservice.checkUser(user)){
            Identity identity = new Identity(user.getUsername(),UserType.Normal);
            AppContext.getInstance().CheckAdd(identity,request.getSession());
            request.getSession().setAttribute("login", UserType.Normal);
            request.getSession().setAttribute("type","normal");


            model.addAttribute("message","login success");
            return new ModelAndView("success");
        }
        model.addAttribute("message","login failed");
        return new ModelAndView("login");
    }

    @Login
    @RequestMapping(value = "list.do",method = RequestMethod.GET)
    public ModelAndView listAllUsers(Model model){
         List<User> list = userservice.getAllUsers();
         model.addAttribute("list",list);
        return new ModelAndView("listUsers");
    }

    @Login
    @RequestMapping(value = "logout.do",method = RequestMethod.GET)
    public String logout( Model model,HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

}
