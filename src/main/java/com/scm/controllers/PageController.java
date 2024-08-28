package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.Builder;



@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Person");
        // userForm.setAbout("This is about : Write something about yourself")
        model.addAttribute("userForm", userForm);
        return "register";
    }
    
    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("Processing Registration");
        System.out.println(userForm);

        // validate userForm
        //save to database
        //user service
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://potomac.edu/wp-content/uploads/2020/12/benefits-of-coding-e1606911064541.jpg")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://potomac.edu/wp-content/uploads/2020/12/benefits-of-coding-e1606911064541.jpg");


        User savedUser = userService.saveUser(user);

        System.out.println("user saved:");


        Message message = Message.builder().content("Registration successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        return "redirect:/register";
    }
    
}
