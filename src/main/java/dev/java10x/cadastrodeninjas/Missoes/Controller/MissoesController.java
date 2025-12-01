package dev.java10x.cadastrodeninjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {



    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada";
    }

    @GetMapping("/listar")
    public String listarMissao(){
        return "Missoes Listadas";
    }
}
