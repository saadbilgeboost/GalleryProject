package com.saad.monolithicproject.controller;

import com.saad.monolithicproject.repository.entity.User;
import com.saad.monolithicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Optional;

import static com.saad.monolithicproject.constants.EndPoints.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
        private final UserService userService;
        @GetMapping(HOME)
        public ModelAndView home(Long user_id){
            User user = userService.findById(user_id);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("user", user);
            modelAndView.setViewName("home");
            return modelAndView;
        }
}
