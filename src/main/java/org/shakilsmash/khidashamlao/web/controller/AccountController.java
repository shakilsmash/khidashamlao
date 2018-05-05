package org.shakilsmash.khidashamlao.web.controller;

import org.shakilsmash.khidashamlao.Stuff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/")
public class AccountController {

    private static final String VIEW_PATH = "/";
    private static final String INDEX_PATH = VIEW_PATH + "index"; //eta client er baire toh, view folder er bhitore
    private static final String SIGNUP_PATH = VIEW_PATH + "client/account/signup";
    private static final String TEST_PATH = "/test/thymeleaf";

    @GetMapping(value = "")
    public String index() {
        return INDEX_PATH; //index baad diye dite hobe ?
    }

    @GetMapping(value = "signup")
    public String signup() {
        return SIGNUP_PATH; //index baad diye dite hobe ?
    }

    @GetMapping(value = "test")
    public String test(Model model) {
        Stuff stuff = new Stuff();
        model.addAttribute("page", stuff);
        model.addAttribute("home", "Hello");
        return TEST_PATH; //index baad diye dite hobe ?
    }

    @RequestMapping
    @GetMapping(value = "test1")
    public String ttest() {
        return "why not working";
    }
}
