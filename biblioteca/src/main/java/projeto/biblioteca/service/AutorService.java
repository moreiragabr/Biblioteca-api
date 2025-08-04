package projeto.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto.biblioteca.entity.Autor;
import projeto.biblioteca.repository.AutorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public Autor findById(Long id) {
        return autorRepository.getById(id);
    }

    public List<Autor> findAll() {
        return autorRepository.getAutores();
    }

    public Autor save(Autor autor) {
        // Você pode adicionar validações aqui antes de salvar
        return autorRepository.save(autor);
    }

    public Autor update(Long id, Autor autor) {
        // Valida se o autor com o ID fornecido existe antes de atualizar
        Autor autorExistente = findById(id);
        if (autorExistente == null) {
            throw new IllegalArgumentException("Autor com ID " + id + " não encontrado.");
        }
        return autorRepository.update(id, autor);
    }

    public void delete(Long id) {
        // Valida se o autor com o ID fornecido existe antes de deletar
        Autor autorExistente = findById(id);
        if (autorExistente == null) {
            throw new IllegalArgumentException("Autor com ID " + id + " não encontrado.");
        }
        autorRepository.delete(id);
    }
}