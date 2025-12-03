package dev.java10x.cadastrodeninjas.Ninjas.Controller;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaDTO;

import dev.java10x.cadastrodeninjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja bem-vindo";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){

        return ninjaService.criarNinja(ninja);
    }


    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas (){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarNinja (@PathVariable Long id){
        return ninjaService.mostrarNinja(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
            return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }


    // Deletar ninja(DELETE)
    @DeleteMapping("/deletarID/{id}")
    public void deletarPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }


}
