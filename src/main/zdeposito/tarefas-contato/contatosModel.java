package com.example.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class contatosModel {
    // Lista que armazenará os contatos em memória
    public static List<Map<String, String>> contatos = new ArrayList<>();

    // Variável para controlar o próximo ID disponível
    public static int proximoId = 1;
}
