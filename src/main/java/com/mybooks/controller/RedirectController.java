package com.mybooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping("/**")  // Handle all requests
    public String redirectToTarget() {
        String redirectUrl = "https://mybooks.up.railway.app";
        return "redirect:" + redirectUrl;
    }
}
