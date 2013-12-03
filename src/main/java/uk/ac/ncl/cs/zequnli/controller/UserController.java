package uk.ac.ncl.cs.zequnli.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uk.ac.ncl.cs.zequnli.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userservice;

}
