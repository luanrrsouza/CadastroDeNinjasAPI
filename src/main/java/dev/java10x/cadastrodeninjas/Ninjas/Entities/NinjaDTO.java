package dev.java10x.cadastrodeninjas.Ninjas.Entities;

import dev.java10x.cadastrodeninjas.Missoes.Entities.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {


    private Long id;
    private String imgUrl;
    private String ranking;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
}
