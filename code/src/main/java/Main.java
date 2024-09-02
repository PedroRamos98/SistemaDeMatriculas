import model.*;

import java.io.*;
import java.util.*;

public class Main {
    private static Secretaria secretaria = new Secretaria();
    c

    public static void main(String[] args) {
        carregarDados();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("|################################|");
            System.out.println("|          1. Login              |");
            System.out.println("|          2. Cadastrar          |");
            System.out.println("|          3. Sair               |");
            System.out.println("|################################|");;
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
                salvarDados();
                break;
            }
        }
    }

    private static Usuario autenticarUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.login(email, senha)) {
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
        System.out.println("Tipo de Usuário (1. Aluno, 2. Professor): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Usuario novoUsuario = null;
        if (tipo == 1) {
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Curso: ");
            String curso = scanner.nextLine();
            novoUsuario = new Aluno(usuarios.size() + 1, nome, email, senha, matricula, curso);
        } else if (tipo == 2) {
            System.out.print("Departamento: ");
            String departamento = scanner.nextLine();
            novoUsuario = new Professor(usuarios.size() + 1, nome, email, senha, departamento);
        }

        if (novoUsuario != null) {
            usuarios.add(novoUsuario);
            salvarDados();
            System.out.println("Cadastro criado com sucesso!");
        } else {
            System.out.println("Tipo de usuário inválido.");
        }
    }

    private static void menuAluno(Aluno aluno, Scanner scanner) {
        int opcao = 0;
        while (opcao!=4) {
            System.out.println("|#################################|");
            System.out.println("|   1. Matricular em Disciplina   |");
            System.out.println("|   2. Cancelar Matrícula         |");
            System.out.println("|   3. Gerar curriculo            |");
            System.out.println("|   4. Sair                       |");
            System.out.println("|#################################|");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
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

                    break;
                case 4:
                    break;
            }

        }
    }

    private static void menuProfessor(Professor professor, Scanner scanner) {
        while (true) {
            System.out.println("|#################################|");
            System.out.println("|       1. Consultar Alunos       |");
            System.out.println("|       2. Sair                   |");
            System.out.println("|#################################|");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            if (opcao == 1) {
                System.out.print("Código da Disciplina: ");
                String codigo = scanner.nextLine();
                Disciplina disciplina = buscarDisciplina(codigo);
                if (disciplina != null) {
                    professor.consultarAlunos(disciplina);
                } else {
                    System.out.println("Disciplina não encontrada.");
                }
            } else if (opcao == 2) {
                break;
            }
        }
    }

    private static void menuSecretaria(Secretaria secretaria, Scanner scanner) {
        while (true) {
            System.out.println("1. Gerar Currículo");
            System.out.println("2. Criar Disciplina");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            if (opcao == 1) {
                System.out.print("ID do Aluno: ");
                int id = scanner.nextInt();
                Aluno aluno = buscarAluno(id);
                if (aluno != null) {
                    secretaria.gerarCurriculo(aluno);
                } else {
                    System.out.println("Aluno não encontrado.");
                }
            } else if (opcao == 2) {
                System.out.print("Código da Disciplina: ");
                String codigo = scanner.nextLine();
                System.out.print("Nome da Disciplina: ");
                String nome = scanner.nextLine();
                System.out.print("Número de Créditos: ");
                int numCred = scanner.nextInt();
                scanner.nextLine();
                secretaria.criarDisciplina(disciplinas, codigo, nome, numCred);
                salvarDados();
            } else if (opcao == 3) {
                break;
            }
        }
    }

    private static Disciplina buscarDisciplina(String codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    private static Aluno buscarAluno(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Aluno && usuario.getId() == id) {
                return (Aluno) usuario;
            }
        }
        return null;
    }

    private static void carregarDados() {
        File file = new File("dados.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
            }
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                usuarios = (List<Usuario>) ois.readObject();
                disciplinas = (List<Disciplina>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar dados: " + e.getMessage());
            }
        }
    }

    private static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.txt"))) {
            oos.writeObject(usuarios);
            oos.writeObject(disciplinas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public static void salvarCurriculos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("curriculos.txt"))) {
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Aluno) {
                    Aluno aluno = (Aluno) usuario;
                    oos.writeObject(aluno);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar currículos: " + e.getMessage());
        }
    }

    public static void carregarCurriculos() {
        File file = new File("curriculos.txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    Aluno aluno = (Aluno) ois.readObject();
                    System.out.println("Currículo do Aluno: " + aluno.getNome());
                    System.out.println("Disciplinas Obrigatórias:");
                    for (Disciplina disciplina : aluno.getDisciplinasObrigatorias()) {
                        System.out.println(disciplina.getNome());
                    }
                    System.out.println("Disciplinas Optativas:");
                    for (Disciplina disciplina : aluno.getDisciplinasOptativas()) {
                        System.out.println(disciplina.getNome());
                    }
                }
            } catch (EOFException e) {
                System.out.println("Currículos carregados com sucesso!");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar currículos: " + e.getMessage());
            }
        }
    }

    public static void salvarDisciplinas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("disciplinas.txt"))) {
            oos.writeObject(disciplinas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }

    public static void carregarDisciplinas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("disciplinas.txt"))) {
            disciplinas = (List<Disciplina>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
        }
    }







}