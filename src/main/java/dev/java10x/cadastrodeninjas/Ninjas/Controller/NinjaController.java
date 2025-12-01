package dev.java10x.cadastrodeninjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja bem-vindo";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }



    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas (){
        return "Mostrar ninja";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId (){
        return "Mostrar ninja por id";
    }
    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarPorID(){
        return "Alterar ninja por id";
    }


    // Deletar ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarPorID(){
        return "Deletar ninja por id";
    }


}
