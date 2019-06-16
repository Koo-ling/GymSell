package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.enums.ExceptionEnum;
import com.ecut.gymonlineshopping.exception.GymException;
import com.ecut.gymonlineshopping.form.LoginForm;
import com.ecut.gymonlineshopping.form.RegisterForm;
import com.ecut.gymonlineshopping.pojo.User;
import com.ecut.gymonlineshopping.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @Author: Selune
 * @Date: 2019/6/13 12:30
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public ModelAndView registerForm(Model model) throws Exception {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/register", "userModel", model);
    }

    @PostMapping
    public ModelAndView register(@Valid RegisterForm userForm,
                                 BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new GymException(ExceptionEnum.PARAM_ERROR.getCode(),
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        if (service.findByName(userForm.getName())) {
            throw new GymException(ExceptionEnum.MEMBER_EXIST);
        }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        service.registerUser(user);
        return new ModelAndView("redirect:/users/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm loginForm,
                              BindingResult bindingResult) throws Exception {
        User result = service.findByNameAndPassword(loginForm.getName(), loginForm.getPassword());

        if (bindingResult.hasErrors()) {
            throw new GymException(ExceptionEnum.PARAM_ERROR.getCode(),
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        if (null == result) {
            throw new GymException(ExceptionEnum.MEMBER_NOT_EXIST);
        }
        if (result.getRole() == 0) {
            return new ModelAndView("redirect:/index/member");
        } else if (result.getRole() == 1) {
            return new ModelAndView("redirect:/index/admin");
        }
        return new ModelAndView("redirect:/login");
    }


}
