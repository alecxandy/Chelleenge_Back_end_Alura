package br.com.alexandre.Desafio.Back.end.domain;
import br.com.alexandre.Desafio.Back.end.util.CategoriasEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private CategoriasEnum categoriasEnum;
}
