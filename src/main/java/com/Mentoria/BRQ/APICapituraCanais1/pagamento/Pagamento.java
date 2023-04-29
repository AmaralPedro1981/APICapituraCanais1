package com.Mentoria.BRQ.APICapituraCanais1.pagamento;

import com.Mentoria.BRQ.APICapituraCanais1.modelo.Status;
import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max = 100)
    private  String nome;

    @NotBlank
    @Size(max = 19)
    private String numero;

    @NotBlank
    @Size(max = 7)
    private String expiracao;

    @Size(max = 20)
    private String semana;

    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;


    @Size(max = 20)
    private String dia;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private long formaDePagamento;
}

