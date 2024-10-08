package main.java.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Secretaria {
    private LinkedList<Curriculo> curriculos;



    public void gerarCurriculo(Aluno aluno) {

    }

    public void criarDisciplina() {

    }

    public void matricularAluno(Aluno aluno, String codigoTurma) {
        Curriculo curriculoMateria = curriculos.stream()
                .filter(c -> c.getCurso().equals(aluno.getCurso()))
                .findFirst()
                .orElse(null);
        if (curriculoMateria != null) {
            curriculoMateria.matricularAluno(aluno, codigoTurma);
        } else {
            System.out.println("Currículo não encontrado para o curso do aluno.");
        }
    }

    public void cancelarMatricula(Aluno aluno, String codigoDisciplina) {
        Curriculo curriculoMateria = curriculos.stream()
                .filter(c -> c.getCurso().equals(aluno.getCurso()))
                .findFirst()
                .orElse(null);

        if (curriculoMateria != null) {
            curriculoMateria.cancelarMatricula(aluno, codigoDisciplina);
        } else {
            System.out.println("Currículo não encontrado para o curso do aluno.");
        }
    }
    public void mostrarTodasTurmas(Aluno aluno) {
        for (Curriculo curriculo : curriculos) {
           if (curriculo.getCurso().equals(aluno.getCurso())){
               curriculo.printTurmas();
           }
        }
    }

    public void mostrarTurmasMatriculadas(Aluno aluno){
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getCurso().equals(aluno.getCurso())) {
                curriculo.printTurmasMatriculadas(aluno);
            }
        }
    }

    public void mostrarTurmasProfessor(Professor professor){
        for (Curriculo curriculo:curriculos)
            curriculo.getTurmasProfessor(professor);
    }

    public void mostrarCurriculoAluno(Aluno aluno) {
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getCurso().equals(aluno.getCurso())){
                curriculo.printTurmas();
            }
        }
    }


}