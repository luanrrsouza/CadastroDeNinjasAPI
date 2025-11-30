package dev.java10x.cadastrodeninjas.Missoes.Repository;

import dev.java10x.cadastrodeninjas.Missoes.Entities.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long > {
}
