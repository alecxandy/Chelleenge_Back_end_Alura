package br.com.alexandre.Desafio.Back.end.repository;

import br.com.alexandre.Desafio.Back.end.domain.Receitas;
import br.com.alexandre.Desafio.Back.end.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> nome(String nome);
}
