package dev.java10x.cadastrodeninjas.Missoes.Entities;


import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "tb_missoes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private MissoesEnum dificuldade;

    // OneToMany - Uma missão para muitos ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;



}

