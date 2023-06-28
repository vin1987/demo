package org.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class demoController {
    @GetMapping("date")
    public String getDate(){
        return "Hell world";
    }
}
