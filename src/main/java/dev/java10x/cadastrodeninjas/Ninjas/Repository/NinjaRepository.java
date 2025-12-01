package dev.java10x.cadastrodeninjas.Ninjas.Repository;

import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
