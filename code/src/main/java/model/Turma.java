package main.java.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    private String codigoTurma;
    private Boolean status;
    private Professor professor;
    private Disciplina disciplina;
    private LinkedList<Aluno> listaAlunos;

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        if (listaAlunos.size()>= 2) status = true;
    }

    public void removerAluno(Aluno aluno) {
        listaAlunos.remove(aluno);
        if (listaAlunos.size()<=2) {
            status = false;
        }
    }

    public int getNumeroAlunos(){
        return listaAlunos.size();
    }

    public String getCodigoDisciplina(){
        return disciplina.getCodigo();
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public boolean isMatriculado(Aluno aluno) {
        return listaAlunos.contains(aluno);
    }

    public boolean haveProfessor(Professor professor) {
        return this.professor.equals(professor);}

    public void printTurma() {
        System.out.println("#############################################################");
        System.out.println("| Disciplina: " + disciplina.getNome());
        System.out.println("| Obrigatoria: " + disciplina.getObrigatoria().toString());
        System.out.println("| Professor: " + professor.getNome());
        System.out.println("| Codigo Turma: " + this.codigoTurma);
        System.out.println("| Numero de Alunos Matriculadas: " + this.listaAlunos.size());
        System.out.println("#############################################################");
    }

    public void printCurriculo(){
        System.out.println("#############################################################");
        System.out.println("| Disciplina: " + disciplina.getNome());
        System.out.println("| Numero de creditos: " + disciplina.getNumCred());
        System.out.println("| Obrigatoria: " + disciplina.getObrigatoria().toString());
        System.out.println("| Professor: " + professor.getNome());
        System.out.println("| Codigo Turma: " + this.codigoTurma);
        System.out.println("#############################################################");
    }

    public void printListaAlunos(){
        System.out.println("\n#############################################################");
        System.out.println("| Disciplina: " + disciplina.getNome());
        System.out.println("| Obrigatoria: " + disciplina.getObrigatoria().toString());
        System.out.println("| Professor: " + professor.getNome());
        System.out.println("| Codigo Turma: " + this.codigoTurma);
        System.out.println("| Numero de Alunos Matriculadas: " + this.listaAlunos.size());
        System.out.println("#############################################################");
        System.out.println("####                   Lista de Alunos                   ####");
        for (Aluno aluno:listaAlunos)
            System.out.println("#- " + aluno.getNome());

    }


}
