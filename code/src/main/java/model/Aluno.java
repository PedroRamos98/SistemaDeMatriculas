package model;

import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;


    public Aluno(int id, String nome, String email, String senha, String matricula, String curso) {
        super(id, nome, email, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    // Getters and Setters
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