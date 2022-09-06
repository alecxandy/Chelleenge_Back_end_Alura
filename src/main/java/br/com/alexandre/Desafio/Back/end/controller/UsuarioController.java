package br.com.alexandre.Desafio.Back.end.controller;

import br.com.alexandre.Desafio.Back.end.domain.Usuario;
import br.com.alexandre.Desafio.Back.end.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario) {
        List<Usuario> despesasList = usuarioService.findByNome(usuario.getNome());
        if (despesasList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(usuario.getId());
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> list() {
        List<Usuario> usuarioList = usuarioService.findAll();
        if (usuarioList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(usuarioList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok().body(usuarioOptional);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/descricao")
    public List<Usuario> findByNome(String nome) {
        return usuarioService.findByNome(nome);
    }


    //responsavel filtrar os resultados dos erros e enviar junto response
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExeception(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

        });


        return errors;
    }
}
