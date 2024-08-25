package model;

import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int creditos;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
        this.alunosMatriculados = new ArrayList<>();
    }

    public boolean matricularAluno(Aluno aluno) {
      
        return false;
    }

    public boolean cancelarMatricula(Aluno aluno) {

        return false;
    }

    public List<Aluno> getAlunosMatriculados() {

        return null;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
