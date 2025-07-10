package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class passo9 {
    
    @GetMapping("/json2")
    public Map<String, String> json2() {
        return Map.of("nome","William");
    }
}
