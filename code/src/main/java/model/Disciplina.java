package main.java.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {
    private String codigo;
    private Boolean obrigatoria;
    private String nome;
    private int numCred;


    public Disciplina(String codigo, String nome, int numCred) {
        this.codigo = codigo;
        this.nome = nome;
        this.numCred = numCred;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCred() {
        return numCred;
    }

    public void setNumCred(int numCred) {
        this.numCred = numCred;
    }

    public Boolean getObrigatoria() {
        return obrigatoria;
    }


}