package projeto.biblioteca.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import projeto.biblioteca.entity.Autor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutorRepository {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Getter
    private final List<Autor> autores = new ArrayList<>();

    public Autor save(Autor autor) {
        atomicInteger.incrementAndGet();
        autor.setId((long) atomicInteger.get());
        autores.add(autor);
        return autor;
    }

    public void delete(Long id) {
        autores.removeIf(autor -> autor.getId().equals(id));
    }

    public Autor update(Long id, Autor autorUpdate) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                autor.setNome(autorUpdate.getNome());
                autor.setCpf(autorUpdate.getCpf());
                autor.setIdade(autorUpdate.getIdade());
                return autor;
            }
        }
        return null; // ou lançar uma exceção
    }

    public Autor getById(Long id) {
        return autores.stream()
                .filter(autor -> autor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}