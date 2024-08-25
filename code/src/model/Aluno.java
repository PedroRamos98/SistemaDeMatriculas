package model;

public class Aluno extends Usuario {
    private String matricula;
    private String nome;

    public Aluno(String login, String senha, String matricula, String nome) {
        super(login, senha);
        this.matricula = matricula;
        this.nome = nome;
    }

    public boolean matricularEmDisciplina(Disciplina disciplina) {
        // Método não implementado
        return false;
    }

    public boolean cancelarMatricula(Disciplina disciplina) {
        // Método não implementado
        return false;
    }

    public Disciplina buscarDisciplina(String nome) {
        // Método não implementado
        return null;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
