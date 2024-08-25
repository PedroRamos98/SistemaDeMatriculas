package model;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;

    public Aluno(int id, String nome, String email, String senha, String matricula, String curso) {
        super(id, nome, email, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    public void matricularDisciplina(Disciplina disciplina) {
        // Implementar lógica de matrícula
    }

    public void cancelarMatricula(Disciplina disciplina) {
        // Implementar lógica de cancelamento de matrícula
    }

    // Getters e Setters
}