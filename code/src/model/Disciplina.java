package model;

public class Disciplina {
    private String codigo;
    private String nome;
    private int creditos;
    private Professor professor;

    public Disciplina(String codigo, String nome, int creditos, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.creditos = creditos;
        this.professor = professor;
    }

    // Getters e Setters
}