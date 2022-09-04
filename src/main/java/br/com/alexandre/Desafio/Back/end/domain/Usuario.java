package br.com.alexandre.Desafio.Back.end.domain;

import java.util.List;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Usuario {

    @Id
    private Long id;
    private String nome;
    private String cpf;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)//lazy = carregamento lento
    private List<Despesas> despesasList;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Receitas> receitasList;
}
