package dev.java10x.cadastrodeninjas.Ninjas.Controller;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){

        return ninjaService.criarNinja(ninja);
    }


    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas (){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinja (@PathVariable Long id){
        return ninjaService.mostrarNinja(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarPorID(){
        return "Alterar ninja por id";
    }


    // Deletar ninja(DELETE)
    @DeleteMapping("/deletarID/{id}")
    public void deletarPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }


}
