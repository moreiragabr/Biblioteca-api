package projeto.biblioteca.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import projeto.biblioteca.entity.Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BibliotecaRepository {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Getter
    private List<Biblioteca> bibliotecas = new ArrayList<>();

    public Biblioteca save(Biblioteca biblioteca) {
        atomicInteger.incrementAndGet();
        biblioteca.setId((long) atomicInteger.get());
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public void delete(Long id) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                bibliotecas.remove(biblioteca);
                break;
            }
        }
    }

    public Biblioteca update(Long id, Biblioteca bibliotecaUpdate) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                biblioteca.setNome(bibliotecaUpdate.getNome());
                biblioteca.setTelefone(bibliotecaUpdate.getTelefone());
                return biblioteca;
            }
        }
        return null;
    }

    public Biblioteca getById(Long id) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                return biblioteca;
            }
        }
        return null;
    }
}