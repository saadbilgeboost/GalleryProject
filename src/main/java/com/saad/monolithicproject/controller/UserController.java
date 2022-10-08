package com.saad.monolithicproject.controller;

import com.saad.monolithicproject.dto.request.UserSaveRequestDto;
import com.saad.monolithicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.saad.monolithicproject.constants.EndPoints.SAVE;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping(SAVE)
    public ModelAndView save(UserSaveRequestDto dto){
        userService.save(dto);
        return new ModelAndView("redirect:/login");
    }
}
