package br.com.alexandre.Desafio.Back.end.domain;

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
public class Receitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double valor;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JoinColumn(nullable = false,name = "usuarioReceita_id")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Receitas receitas = (Receitas) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
