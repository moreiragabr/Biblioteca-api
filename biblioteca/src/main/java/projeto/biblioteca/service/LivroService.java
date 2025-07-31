package projeto.biblioteca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto.biblioteca.entity.Livro;
import projeto.biblioteca.repository.LivroRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro findById(Long id) {
        return livroRepository.getById(id);
    }


    public List<Livro> findAll() {
        return livroRepository.getLivros();
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro update(Long id, Livro livro) {
        return livroRepository.update(id, livro);
    }

    public void delete(Long id) {
        livroRepository.delete(id);
    }

}
