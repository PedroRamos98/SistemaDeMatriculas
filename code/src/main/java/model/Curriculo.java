package model;

import java.util.LinkedList;


public class Curriculo {
    private String curso;
    private LinkedList <Disciplina> disciplinasObrigatorias;
    private LinkedList <Disciplina> disciplinasOptativas;
    private LinkedList <Turma> turmas;

    public Curriculo() {
    }

    public void matricularAluno(Aluno aluno, String codigoDisciplina) {
        for (Turma turma : turmas) {
            if (turma.getCodigoTurma().equals(codigoDisciplina) && turma.getNumeroAlunos() < 60) {
                turma.adicionarAluno(aluno);
                return;
            }
        }
        System.out.println("Disciplina com código " + codigoDisciplina + " não encontrada ou todas as turmas estão cheias.");
    }

    public void cancelarMatricula(Aluno aluno, String codigoTurma) {
        for (Turma turma : turmas) {
            if (turma.getCodigoTurma().equals(codigoTurma)) {
                turma.removerAluno(aluno);
                return;
            }
        }
        System.out.println("Disciplina com código " + codigoTurma + " não encontrada.");
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void printTurmas() {
        for (Turma turma:turmas){
            turma.printTurma();
        }
    }

    public void printTurmasMatriculadas(Aluno aluno) {
        for (Turma turma:turmas){
            if(turma.isMatriculado(aluno)){
                turma.printTurma();
            };
        }
    }
}

