package model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public boolean login(String email, String senha) {
        // Implementar lógica de login
        return false;
    }

    // Getters e Setters
}