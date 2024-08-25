package model;
import java.util.List;

public class Professor extends Usuario {
    private String nome;

    public Professor(String login, String senha, String nome) {
        super(login, senha);
        this.nome = nome;
    }

    public List<Aluno> consultarAlunosPorDisciplina(Disciplina disciplina) {
        // Método não implementado
        return null;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
