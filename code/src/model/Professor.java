package model;

public class Professor extends Usuario {
    private String departamento;

    public Professor(int id, String nome, String email, String senha, String departamento) {
        super(id, nome, email, senha);
        this.departamento = departamento;
    }

    public void consultarAlunos(Disciplina disciplina) {
        // Implementar lógica de consulta de alunos
    }

    // Getters e Setters
}