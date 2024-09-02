package main.java;

import main.java.model.Aluno;
import main.java.model.Professor;
import main.java.model.Secretaria;
import main.java.model.Usuario;

import java.io.*;
import java.util.*;

public class Main {
    private static Secretaria secretaria = new Secretaria();
    private static List<Usuario> usuarios = new LinkedList<>(); // Initialize the list

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("|################################|");
            System.out.println("|          1. Login              |");
            System.out.println("|          2. Cadastrar          |");
            System.out.println("|          3. Sair               |");
            System.out.println("|################################|");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                Usuario usuario = autenticarUsuario(email, senha);
                if (usuario != null) {
                    if (usuario instanceof Aluno) {
                        menuAluno((Aluno) usuario, scanner);
                    } else if (usuario instanceof Professor) {
                        menuProfessor((Professor) usuario, scanner);
                    }
                } else {
                    System.out.println("Credenciais inválidas.");
                }
            } else if (opcao == 2) {
                criarCadastro(scanner);
            } else if (opcao == 3) {
                break;
            }
        }
    }

    private static Usuario autenticarUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private static void criarCadastro(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Tipo de usuário (1 para Aluno, 2 para Professor): ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Usuario novoUsuario;
        if (tipoUsuario == 1) {
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Curso: ");
            String curso = scanner.nextLine();
            novoUsuario = new Aluno(nome, email, senha, matricula, curso);
        } else if (tipoUsuario == 2) {
            novoUsuario = new Professor(nome, email, senha);
        } else {
            System.out.println("Tipo de usuário inválido.");
            return;
        }

        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private static void menuAluno(Aluno aluno, Scanner scanner) {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("|#################################|");
            System.out.println("|   1. Matricular em Disciplina   |");
            System.out.println("|   2. Cancelar Matrícula         |");
            System.out.println("|   3. Gerar curriculo            |");
            System.out.println("|   4. Sair                       |");
            System.out.println("|#################################|");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    secretaria.mostrarTodasTurmas(aluno);
                    System.out.print("Código da Disciplina: ");
                    String codigoTurmaMatricula = scanner.nextLine();
                    secretaria.matricularAluno(aluno, codigoTurmaMatricula);
                    break;
                case 2:
                    System.out.print("Código da Disciplina: ");
                    String codigoTurmaCancelamento = scanner.nextLine();
                    secretaria.cancelarMatricula(aluno, codigoTurmaCancelamento);
                    break;
                case 3:
                    secretaria.mostrarCurriculoAluno(aluno);
                    break;
                case 4:
                    break;
            }
        }
    }

    private static void menuProfessor(Professor professor, Scanner scanner) {
        int opcao = 0;
        while (opcao != 2) {
            System.out.println("|#################################|");
            System.out.println("|   1. Mostrar turmas             |");
            System.out.println("|   2. Sair                       |");
            System.out.println("|#################################|");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    secretaria.mostrarTurmasProfessor(professor);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void menuSecretaria(Secretaria secretaria, Scanner scanner) {
    }
}