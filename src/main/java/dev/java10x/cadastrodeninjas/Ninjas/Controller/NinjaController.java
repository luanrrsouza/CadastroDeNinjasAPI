package dev.java10x.cadastrodeninjas.Ninjas.Controller;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaDTO;

import dev.java10x.cadastrodeninjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + ninjaDTO.getNome() + "(ID): " + ninjaDTO.getId());
    }


    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas (){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK).body(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinja (@PathVariable Long id){

         NinjaDTO ninjaPorId = ninjaService.mostrarNinja(id);

         if(ninjaPorId != null) {
             return ResponseEntity.ok(ninjaPorId);
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado!");
         }

    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
            NinjaDTO ninjaAtt =  ninjaService.atualizarNinja(id, ninjaAtualizado);

            if (ninjaAtt != null) {
                return ResponseEntity.status(HttpStatus.OK).body(ninjaAtt);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }


    // Deletar ninja(DELETE)
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarPorID(@PathVariable Long id){
        if(ninjaService.mostrarNinja(id) != null ) {

            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");

        }

        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID não encontrado");
        }

    }


}
