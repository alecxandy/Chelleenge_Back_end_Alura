package br.com.alexandre.Desafio.Back.end.repository;

import br.com.alexandre.Desafio.Back.end.domain.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {
}
