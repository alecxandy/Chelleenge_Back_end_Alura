package br.com.alexandre.Desafio.Back.end.domain;

import br.com.alexandre.Desafio.Back.end.util.CategoriasEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double valor;

    @JoinColumn(name = "usuarioDespesa_id", nullable = false)//associando a coluna e não nula
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private CategoriasEnum categoriasEnum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Despesas despesas = (Despesas) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
