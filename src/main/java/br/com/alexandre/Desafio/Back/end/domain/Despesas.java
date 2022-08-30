package br.com.alexandre.Desafio.Back.end.domain;
import br.com.alexandre.Desafio.Back.end.util.CategoriasEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double valor;
    private Date data;


    @Enumerated(EnumType.STRING)
    private CategoriasEnum categoriasEnum;
}
