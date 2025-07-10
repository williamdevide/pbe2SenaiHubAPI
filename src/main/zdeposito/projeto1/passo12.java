package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;

@RestController
public class passo12 {
    
    private List<Map<String, String>> alunos =
        List.of(
            new LinkedHashMap<String, String>() {{
                put("nome", "William");
                put("idade", "43");
                put("email", "william@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Mariana");
                put("idade", "33");
                put("email", "mariana@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Edivan");
                put("idade", "40");
                put("email", "edivan@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "João");
                put("idade", "25");
                put("email", "joao@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Renan");
                put("idade", "37");
                put("email", "renan@gmail.com");
            }}
        );

    @GetMapping("/json5")
    public List<Map<String, String>> json5() {
        return alunos;
    }
}
