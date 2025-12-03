package dev.java10x.cadastrodeninjas.Ninjas.Service;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaDTO;
import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaMapper;
import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }


    //Listar meu ninja por ID
    public NinjaDTO mostrarNinja(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo Ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar um ninja - Tem que ser um metodo VOID

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar o ninja

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
            if(ninjaExistente.isPresent()){
                NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
                ninjaAtualizado.setId(id);
                NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
                return ninjaMapper.map(ninjaSalvo);
            }

            return null;


    }
}
