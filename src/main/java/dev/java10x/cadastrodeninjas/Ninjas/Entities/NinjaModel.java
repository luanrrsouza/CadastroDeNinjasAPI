package dev.java10x.cadastrodeninjas.Ninjas.Entities;


import dev.java10x.cadastrodeninjas.Missoes.Entities.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_cadastro_de_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgUrl;


    private String nome;

    @Column(unique = true)
    private String email;
    private int idade;



    // @ManyToOne - Um ninja tem uma única missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key ou Chave Estrangeira
    private MissoesModel missoes;

}
