package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
public class passo11 {
    
    private List<Map<String, String>> alunos =
       List.of(
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com")
        );

    @GetMapping("/json4")
    public List<Map<String, String>> json4() {
        return alunos;
    }
}
