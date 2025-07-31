package projeto.biblioteca.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import projeto.biblioteca.entity.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LivroRepository {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Getter
    public List<Livro> livros = new ArrayList<>();

    public Livro save(Livro livro) {
        atomicInteger.incrementAndGet();
        livro.setId((long) atomicInteger.get());
        livros.add(livro);
        return livro;
    }

    public Livro update(Long id, Livro livroUp) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livro.setAno(livroUp.getAno());
                livro.setTitulo(livroUp.getTitulo());
                livro.setIssn(livroUp.getIssn());
                livro.setN_pag(livroUp.getN_pag());
                livro.setSinopse(livro.getSinopse());
                return livro;
            }
        }
        return null;
    }

    public void delete(Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livros.remove(livro);
                break;
            }
        }
    }

    public Livro getById(Long id){
        for (Livro livro : livros){
            if(livro.getId().equals(id)){
                return livro;
            }
        }
        return null;
    }
}
