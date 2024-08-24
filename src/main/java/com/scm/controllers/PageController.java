package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page Handler");
        // model.addAttribute("name","Substring Technologies" );
        // model.addAttribute("linkedin","Parisha" );

        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage()
    {
        System.out.println("About page loading");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("Services page loading");
        return "services";
    }

    @RequestMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    @RequestMapping("/login")
    public String login() {
        return new String("login");
    }

    @RequestMapping("/register")
    public String register() {
        return new String("register");
    }
    
}
