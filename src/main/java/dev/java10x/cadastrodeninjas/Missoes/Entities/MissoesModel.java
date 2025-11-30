package dev.java10x.cadastrodeninjas.Missoes.Entities;


import dev.java10x.cadastrodeninjas.Ninjas.Entities.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "tb_missoes")
@Entity
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private MissoesEnum dificuldade;

    // OneToMany - Uma missão para muitos ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, MissoesEnum dificuldade) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public String getNomeDaMissao() {
        return nome;
    }

    public MissoesEnum getDificuldade() {
        return dificuldade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nome = nomeDaMissao;
    }

    public void setDificuldade(MissoesEnum dificuldade) {
        this.dificuldade = dificuldade;
    }
}

