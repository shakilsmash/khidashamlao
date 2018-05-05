package org.shakilsmash.khidashamlao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {

    private static final String VIEW_PATH = "/";
    private static final String INDEX_PATH = VIEW_PATH + "index"; //eta client er baire toh, view folder er bhitore
    private static final String SIGNUP_PATH = VIEW_PATH + "client/account/signup";

    //@GetMapping(value = "page")
    //@ResponseBody
    @RequestMapping("page")
    public String page() {
        //return INDEX_PATH; //index baad diye dite hobe ?
        return INDEX_PATH;
    }

    @RequestMapping("welcome")
    @ResponseBody
    String home() {
       return "Welcome to KhidaShamlao, Visitor!";
    }
}
