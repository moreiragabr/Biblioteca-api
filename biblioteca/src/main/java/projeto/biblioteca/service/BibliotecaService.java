package projeto.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto.biblioteca.entity.Biblioteca;
import projeto.biblioteca.repository.BibliotecaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public Biblioteca findById(Long id) {
        return bibliotecaRepository.getById(id);
    }

    public List<Biblioteca> findAll() {
        return bibliotecaRepository.getBibliotecas();
    }

    public Biblioteca save(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca update(Long id, Biblioteca biblioteca) {
        return bibliotecaRepository.update(id, biblioteca);
    }

    public void delete(Long id) {
        bibliotecaRepository.delete(id);
    }
}
