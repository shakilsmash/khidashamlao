package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("welcome")
    @ResponseBody
    String home() {
        return "Welcome to KhidaShamlao, Visitor!";
    }
}
