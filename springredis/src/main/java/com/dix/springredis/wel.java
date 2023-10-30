package com.dix.springredis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class wel {

    @GetMapping("/welcome")
    public String wel(){
        return "Spring redis is working";
    }
}
