package dev.java10x.cadastrodeninjas.Ninjas.Service;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
import dev.java10x.cadastrodeninjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
