package br.com.alexandre.Desafio.Back.end.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Receitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double valor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

}
