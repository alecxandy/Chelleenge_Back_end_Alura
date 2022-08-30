package br.com.alexandre.Desafio.Back.end.controller;

import br.com.alexandre.Desafio.Back.end.domain.Receitas;
import br.com.alexandre.Desafio.Back.end.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping("/save")
    public ResponseEntity<Receitas> save(@RequestBody Receitas receitas) {
        List<Receitas> receitasList = findBydescricao(receitas.getDescricao());
        if (receitasList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(receitaService.save(receitas));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Receitas> update(@RequestBody Receitas receitas) {
        Optional<Receitas> receitasOptional = receitaService.findById(receitas.getId());
        List<Receitas> receitasList = findBydescricao(receitas.getDescricao());
        if (receitasOptional.isPresent() && receitasList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(receitaService.save(receitas));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Receitas>> list() {
        List<Receitas> receitasList = receitaService.findAll();
        if (receitasList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(receitasList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Receitas>> findById(@PathVariable Long id) {
        Optional<Receitas> receitas = receitaService.findById(id);
        if (receitas.isPresent()) {
            return ResponseEntity.ok().body(receitas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Receitas> receitasOptional = receitaService.findById(id);
        if (receitasOptional.isPresent()) {
            receitaService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/descricao")
    public List<Receitas> findBydescricao(String descricao) {
        return receitaService.findByDescricao(descricao);
    }


}
