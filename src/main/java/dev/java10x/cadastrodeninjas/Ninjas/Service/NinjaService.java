package dev.java10x.cadastrodeninjas.Ninjas.Service;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }


    //Listar meu ninja por ID
    public NinjaModel mostrarNinja(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar um novo Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // Deletar um ninja - Tem que ser um metodo VOID

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar o ninja

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }

        return null;


    }
}
