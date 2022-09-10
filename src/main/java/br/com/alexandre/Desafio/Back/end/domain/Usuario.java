package br.com.alexandre.Desafio.Back.end.domain;

import br.com.alexandre.Desafio.Back.end.constraints.PlacaDeCarro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo não informado")//tem que ser preenchido
    @NotNull//nao nulo
    @Max(value = 50, message = "Ultrapassou o limite de caracteres")//maximo de caracteres
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Campo precisa comerçar com letra maiuscula")
    //Primeira letra do nome maiuscula
    private String nome;

    @Email(message = "Campo invalid!")
    @NotBlank(message = "Campo não informado")
    private String email;

    @CPF(message = "Campo invalid!")
    @NotBlank(message = "Campo não informado")
    private String cpf;

    @NotBlank(message = "Campo não informado")
    @PlacaDeCarro(message = "Campo invalid!")//validação personalizada
    private String placaCarro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//lazy = carregamento lento
    private List<Despesas> despesasList;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Receitas> receitasList;
}
