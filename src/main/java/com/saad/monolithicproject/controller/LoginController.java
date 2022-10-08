package com.saad.monolithicproject.controller;

import com.saad.monolithicproject.dto.request.UserSaveRequestDto;
import com.saad.monolithicproject.repository.entity.Gender;
import com.saad.monolithicproject.repository.entity.User;
import com.saad.monolithicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static com.saad.monolithicproject.constants.EndPoints.*;

@Controller
@RequestMapping(VERSION+API+WEB+LOGIN)
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    @GetMapping(LOGINPAGE)
    public ModelAndView loginPage(){
        String username = "Username";
        String password = "Password";
        ModelAndView modelAndView = new ModelAndView();
        /**
         * The name written inside setViewName should be same with the name of the html file.
         */
        modelAndView.setViewName("login");
        modelAndView.addObject("username",username);
        modelAndView.addObject("password", password);
        return modelAndView;
    }

    @PostMapping(DOLOGIN)
    public ModelAndView doLogin(String txtusername, String txtpassword){
        Optional<User> user = userService.findOptionalByUsernameAndPassword(txtusername,txtpassword);
        ModelAndView modelAndView = new ModelAndView();
        if(user.isPresent()){
            modelAndView.addObject("user_id", user.get().getId());
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }else{
            System.out.println("Wrong username or password.");
        }
        return null;
    }
    @GetMapping(REGISTER)
    public ModelAndView register(){
        //"return new ModelAndView("register")" can also be used but you will not be able to use add object or other functions
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @GetMapping(DOREGISTER)
    public ModelAndView doRegister (String name, String surname, String email, String username, String password, String gender, String birthdate) {
        userService.save(UserSaveRequestDto.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .username(username)
                .password(password)
                .gender(gender(gender))
                .birthdate(dateFormatter(birthdate)).build());
        return new ModelAndView("redirect:loginpage");
    }
    public Gender gender(String gender){
        if(gender.equalsIgnoreCase("Male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }
    public Date dateFormatter(String date){
        SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
        Date dob = null;
        try {
            dob = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return dob;
    }

}
