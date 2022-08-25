package br.com.alexandre.Desafio.Back.end.controller;

import br.com.alexandre.Desafio.Back.end.domain.Despesas;
import br.com.alexandre.Desafio.Back.end.service.DespesasService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/despesas")
public class DespesasController {

    @Autowired
    private DespesasService despesasService;

    @PostMapping("/save")
    public ResponseEntity<Despesas> save(@RequestBody Despesas despesas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(despesasService.save(despesas));
    }

    @PutMapping("/update")
    public ResponseEntity<Despesas> update(@RequestBody Despesas despesas) {
        Optional<Despesas> despesasOptional = despesasService.findById(despesas.getId());
        if (despesasOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(despesasService.save(despesas));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Despesas>> list() {
        List<Despesas> despesasList = (List<Despesas>) despesasService.findAll();
        if (despesasList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(despesasList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Despesas>> findById(@PathVariable Long id) {
        Optional<Despesas> despesasOptional = despesasService.findById(id);
        if (despesasOptional.isPresent()) {
            return ResponseEntity.ok().body(despesasOptional);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Despesas> despesasOptional = despesasService.findById(id);
        if (despesasOptional.isPresent()) {
            despesasService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
