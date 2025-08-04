package projeto.biblioteca.entity;

import lombok.Data;

@Data
public class Autor {
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
}