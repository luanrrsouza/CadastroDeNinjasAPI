package dev.java10x.cadastrodeninjas.Missoes.Controller;

import dev.java10x.cadastrodeninjas.Missoes.Entities.MissoesModel;
import dev.java10x.cadastrodeninjas.Missoes.Service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

   private MissoesService missoesService;
   public MissoesController(MissoesService missoesService){
       this.missoesService = missoesService;
   }

    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoesModel){
       return missoesService.criarMissoes(missoesModel);

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
    public List<MissoesModel> listarMissoes(){
       return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoes(@PathVariable Long id){
       return missoesService.listarMissaoPorId(id);
    }
}
