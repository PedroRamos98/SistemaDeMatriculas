package main.java.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Usuario {
    private String matricula;
    private String curso;

public Aluno(String nome, String email, String senha, String matricula, String curso) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.curso = curso;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}