package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
public class passo10 {
    
    @GetMapping("/json3")
    public List<Map<String, String>> json3() {
        return List.of(
            Map.of("nome","William", 
        "idade", "43",
        "email", "william@gmail.com"),
        Map.of("nome","William", 
        "idade", "43",
        "email", "william@gmail.com")
        );
    }
}
