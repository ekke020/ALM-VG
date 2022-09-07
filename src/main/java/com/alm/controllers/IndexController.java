package com.alm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {


    @GetMapping("/")
    public String welcome() {
        return """
                <h1>Welcome to a simple calculator...</h1>
                <div>Go to /math/add?x={}&y={} for addition</div>
                <div>Go to /math/sub?x={}&y={} for subtraction</div>
                """;
    }

}
