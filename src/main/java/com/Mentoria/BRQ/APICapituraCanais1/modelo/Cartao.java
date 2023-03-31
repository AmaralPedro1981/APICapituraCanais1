package com.Mentoria.BRQ.APICapituraCanais1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data



public class Cartao {
@Id

    private long matricula;
    private String bandeira;
//    private String nome;
    private String banco;
//    private String telefone;
    private Instant datacadastro;

}
