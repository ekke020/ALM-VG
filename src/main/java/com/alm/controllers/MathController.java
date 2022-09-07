package com.alm.controllers;

import com.alm.services.MathService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/add")
    public String addition(@RequestParam(defaultValue = "0") int x, @RequestParam(defaultValue = "0") int y) {
        return "<b>" + x + " + " + y + " = " + mathService.add(x, y) + "</b>";
    }

    @GetMapping("/sub")
    public String subtraction(@RequestParam(defaultValue = "0") int x, @RequestParam(defaultValue = "0") int y) {
        return "<b>" + x + " - " + y + " = " + mathService.subtract(x, y) + "</b>";
    }
}
