package main.java.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class Professor extends Usuario {

    public Professor(String nome, String email, String senha) {
        super(nome, email, senha);
    }



    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", senha='" + getSenha() + '\'' +
                '}';
    }
}