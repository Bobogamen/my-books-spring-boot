package com.mybooks.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class RedirectController {

    @RequestMapping("/**")  // Handle all requests
    public String redirectToTarget(HttpServletRequest request) {

        if (request.getRequestURL().toString().contains("book")) {
            String redirectUrl = "https://mybooksbg.netlify.app";
            return "redirect:" + redirectUrl;
        } else if (request.getRequestURL().toString().contains("destiny")) {
            String redirectUrl = "https://destiny-library.netlify.app";
            return "redirect:" + redirectUrl;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
