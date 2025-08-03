package projeto.biblioteca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.biblioteca.entity.Editora;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private List<Editora> editoras = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Editora>> listAll() {
        try {
            return new ResponseEntity<>(editoras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable int id) {
        try {
            Editora result = editoras.stream()
                    .filter(e -> e.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Editora> save(@RequestBody Editora editora) {
        try {
            editoras.add(editora);
            return new ResponseEntity<>(editora, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> update(@PathVariable int id, @RequestBody Editora editoraAtualizada) {
        try {
            for (Editora e : editoras) {
                if (e.getId() == id) {
                    e.setNome(editoraAtualizada.getNome());
                    e.setEndereco(editoraAtualizada.getEndereco());
                    e.setTelefone(editoraAtualizada.getTelefone());
                    return new ResponseEntity<>(e, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Editora> partialUpdate(@PathVariable int id, @RequestBody Editora editoraParcial) {
        try {
            for (Editora e : editoras) {
                if (e.getId() == id) {
                    if (editoraParcial.getNome() != null) e.setNome(editoraParcial.getNome());
                    if (editoraParcial.getEndereco() != null) e.setEndereco(editoraParcial.getEndereco());
                    if (editoraParcial.getTelefone() != null) e.setTelefone(editoraParcial.getTelefone());
                    return new ResponseEntity<>(e, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            boolean removed = editoras.removeIf(e -> e.getId() == id);
            if (removed) {
                return new ResponseEntity<>("Editora removida com sucesso!", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Editora não encontrada!", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao remover editora!", HttpStatus.BAD_REQUEST);
        }
    }
}
