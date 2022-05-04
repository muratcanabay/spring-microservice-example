package com.muratcanabay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/sample-api")
    public String getMessage() {
        return "Sample Api";
    }
}
