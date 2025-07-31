package projeto.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.biblioteca.entity.Biblioteca;
import projeto.biblioteca.service.BibliotecaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Biblioteca>> findAll(){
        try{
            var result = bibliotecaService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Long id){
        try{
            var result = bibliotecaService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Biblioteca> save(@RequestBody Biblioteca biblioteca){
        try {
            var result = bibliotecaService.save(biblioteca);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Biblioteca> update(@PathVariable Long id, @RequestBody Biblioteca biblioteca){
        try{
            var result = bibliotecaService.update(id, biblioteca);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            bibliotecaService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
