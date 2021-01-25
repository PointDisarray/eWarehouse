package com.example.springboot;

import com.example.springboot.domain.DBuser;
import com.example.springboot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepository;

    @PostMapping(path="/add")
    public @ResponseBody ModelAndView addNewUser (@RequestParam String name, @RequestParam String message) {

        DBuser usr = new DBuser();
        usr.setName(name);
        usr.setMessage(message);
        userRepository.save(usr);

        return new ModelAndView("redirect:/all");
    }

    @GetMapping(path="/all")
    public @ResponseBody ModelAndView getAllUsers() throws InterruptedException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list.html");
        modelAndView.addObject("usersMessages", userRepository.findAll());
        //Thread.sleep(5000);
        return modelAndView;

    }

    @GetMapping(path="/hello")
    @ResponseBody
    public ModelAndView helloPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello.html");
        return modelAndView;
    }

    @GetMapping(path="/add")
    @ResponseBody
    public ModelAndView getMainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main.html");
        return modelAndView;
    }
}