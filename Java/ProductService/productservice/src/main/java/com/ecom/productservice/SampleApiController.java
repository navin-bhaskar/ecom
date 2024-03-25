package com.ecom.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SampleApiController {
    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name;
    }
    
}
