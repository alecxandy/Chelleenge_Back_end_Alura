package br.com.alexandre.Desafio.Back.end.service;

import br.com.alexandre.Desafio.Back.end.domain.Despesas;
import br.com.alexandre.Desafio.Back.end.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesasService {

    @Autowired
    private final DespesasRepository despesasRepository;

    public DespesasService(DespesasRepository despesasRepository) {
        this.despesasRepository = despesasRepository;
    }

    public Despesas save(Despesas despesas) {
        return despesasRepository.save(despesas);
    }

    public List<Despesas> findAll() {
        return despesasRepository.findAll();
    }

    public Optional<Despesas> findById(Long id) {
        return despesasRepository.findById(id);
    }

    public void delete(Long id) {
        despesasRepository.deleteById(id);
    }
    public List<Despesas> findByDescricao(String descricao) {
        return despesasRepository.descricao(descricao);
    }

}
