package br.com.alexandre.Desafio.Back.end.service;

import br.com.alexandre.Desafio.Back.end.domain.Receitas;
import br.com.alexandre.Desafio.Back.end.domain.Usuario;
import br.com.alexandre.Desafio.Back.end.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> findByNome(String nome) {
        return usuarioRepository.nome(nome);
    }

}
