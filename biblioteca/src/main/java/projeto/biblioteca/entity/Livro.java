package projeto.biblioteca.entity;

import lombok.Data;

@Data
public class Livro {
    private Long id;
    private String issn;
    private String titulo;
    private String sinopse;
    private String ano;
    private String n_pag;
}
