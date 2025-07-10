package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
public class passo10 {
    
    @GetMapping("/json3")
    public List<Map<String, String>> json3() {
        return List.of(
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","Mariana", "idade", "33", "email", "mariana@gmail.com"),
            Map.of("nome","Edivan", "idade", "40", "email", "edivan@gmail.com"),
            Map.of("nome","João", "idade", "25", "email", "joao@gmail.com"),
            Map.of("nome","Renan", "idade", "37", "email", "renan@gmail.com")
        );
    }
}
