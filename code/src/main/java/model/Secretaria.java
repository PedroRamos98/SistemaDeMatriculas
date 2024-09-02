package model;

import java.util.LinkedList;


public class Secretaria {
    private LinkedList<Curriculo> curriculos;


    public Secretaria(){}


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

    public void mostrarAlunosDaTurma(Turma turma) {
        for(Aluno aluno: alunos){



        }
    }





}