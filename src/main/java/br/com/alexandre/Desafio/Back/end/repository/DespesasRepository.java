package br.com.alexandre.Desafio.Back.end.repository;

import br.com.alexandre.Desafio.Back.end.domain.Despesas;
import br.com.alexandre.Desafio.Back.end.domain.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {
    List<Despesas> descricao(String despesas);
}
