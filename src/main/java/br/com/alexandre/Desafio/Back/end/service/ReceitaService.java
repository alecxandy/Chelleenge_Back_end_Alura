package br.com.alexandre.Desafio.Back.end.service;

import br.com.alexandre.Desafio.Back.end.domain.Receitas;
import br.com.alexandre.Desafio.Back.end.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private final ReceitasRepository receitasRepository;

    public ReceitaService(ReceitasRepository receitasRepository) {
        this.receitasRepository = receitasRepository;
    }

    public Receitas save(Receitas receitas) {
        return receitasRepository.save(receitas);
    }

    public List<Receitas> findAll() {
        return receitasRepository.findAll();
    }

    public Optional<Receitas> findById(Long id) {
        return receitasRepository.findById(id);
    }

    public void delete(Long id) {
        receitasRepository.deleteById(id);
    }

    public List<Receitas> findByDescricao(String descricao) {
        return receitasRepository.descricao(descricao);
    }


}
