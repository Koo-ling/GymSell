package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.config.WebSecurityConfig;
import com.ecut.gymonlineshopping.dto.LoginDTO;
import com.ecut.gymonlineshopping.form.LoginForm;
import com.ecut.gymonlineshopping.form.RegisterForm;
import com.ecut.gymonlineshopping.domain.User;
import com.ecut.gymonlineshopping.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Selune
 * @Date: 2019/6/13 12:30
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/registerForm")
    public ModelAndView registerForm(Model model) throws Exception {
        model.addAttribute("user", new RegisterForm());
        return new ModelAndView("users/register", "register", model);
    }

    @PostMapping(value = "/register")
    public ModelAndView register(RegisterForm registerForm) throws Exception {
        if (service.findByName(registerForm.getName())) {
            throw new Exception("用户已存在");
        }
        User user = new User();
        BeanUtils.copyProperties(registerForm, user);
        service.registerUser(user);
        return new ModelAndView("redirect:/users/loginForm");
    }

    @GetMapping(value = "/loginForm")
    public ModelAndView loginForm(Model model) throws Exception {
        model.addAttribute("account", new LoginDTO());
        return new ModelAndView("users/login", "login", model);
    }

    @PostMapping(value = "/login")
    public ModelAndView login(LoginForm loginForm,
                              Model model,
                              HttpServletRequest request) throws Exception {
        User result = service.findByNameAndPassword(loginForm.getName(), loginForm.getPassword());

        if (null == result) {
            throw new Exception("用户不存在");
        }
        request.getSession().setAttribute("name", result.getName());

        if (result.getRole() == 1) {
            model.addAttribute("username", result.getName());
            return new ModelAndView("redirect:index/admin", "admin", model);
        }
        model.addAttribute("username", result.getName());
        return new ModelAndView("redirect:index/member", "member", model);
    }

    @GetMapping("/index/admin")
    public ModelAndView admin(Model model) {
        model.addAttribute("title", "管理员界面");
        return new ModelAndView("index/admin/admin");
    }

    @GetMapping("/index/member")
    public ModelAndView member(Model model, HttpServletRequest request) {
        model.addAttribute("title", "会员界面");
        model.addAttribute("username", request.getSession().getAttribute("name"));
        return new ModelAndView("index/member/member", "member", model);
    }

    @GetMapping("/loginout")
    public ModelAndView loginout(HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
        return new ModelAndView("users/loginForm");
    }
}
