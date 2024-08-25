package model;

import java.util.Date;

public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private Date dataMatricula;

    public Matricula(Aluno aluno, Disciplina disciplina, Date dataMatricula) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = dataMatricula;
    }


}