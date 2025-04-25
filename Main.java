import java.util.Scanner;

// Classe Base
class Pessoa {
    String cpf;
    String dataNascimento;

    Pessoa(String cpf, String dataNascimento) { //Construtor da classe Pessoa
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    void mostrarDadosPessoa() { //Exibir dados de Pessoa
        System.out.println("CPF: " + cpf);
        System.out.println("Data Nascimento: " + dataNascimento);
    }
}

// Classe Funcionario herda classe base Pessoa
class Funcionario extends Pessoa{
    String nome;

    Funcionario(String cpf, String dataNascimento, String nome) { //Construtor da classe Funcionario
        super(cpf, dataNascimento); //Reutiliza da classe Funcionario
        this.nome = nome;
    }

    void mostrarDadosFuncionario() { // Exibir dados funcionario
        mostrarDadosPessoa();
    }

    void baterPonto() {
        System.out.println("Funcionário bateu ponto");
    }
}

// Subclasse Gerente
class Gerente extends Funcionario {
    Gerente(String cpf, String dataNascimento, String nome) { //Construtor da classe Gerente
        super(cpf, dataNascimento, nome);
    }

    @Override
    void mostrarDadosFuncionario() {
        System.out.println("\nNome do gerente: " + nome);
        super.mostrarDadosFuncionario(); //Reutiliza da classe Funcionario
    }

    void realizarReuniao() {
        System.out.println(nome + " está relizando reunião");
    }
}

// Subclasse Desenvolvedor
class Desenvolvedor extends Funcionario {
    Desenvolvedor(String cpf, String dataNascimento, String nome) { //Construtor da classe Desenvolvedor
        super(cpf, dataNascimento, nome);
    }

    @Override
    void mostrarDadosFuncionario() {
        System.out.println("\nNome do desenvolvedor: " + nome);
        super.mostrarDadosFuncionario(); //Reutiliza da classe Funcionario
    }

    void programar() {
        System.out.println(nome + " está programando");
    }
}

// Subclasse Estagiario
class Estagiario extends Funcionario {
    Estagiario(String cpf, String dataNascimento, String nome) { //Construtor da classe Estagiario
        super(cpf, dataNascimento, nome); //Reutiliza da classe Funcionario
    }

    @Override
    void mostrarDadosFuncionario() {
        System.out.println("\nNome do estagiário: " + nome);
        super.mostrarDadosFuncionario();
    }

    void fazerTarefa() {
        System.out.println(nome + " está realizando tarefas");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Funcionario funcionario1 = null;
        Funcionario funcionario2 = null;
        Funcionario funcionario3 = null;

        int op;

        // Estrtura de repetição pro menu de opção
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar novos funcionários (Só é possível cadastrar 3)"); //Case 1: Cadastra novos funcionários
            System.out.println("2 - Exibir dados dos funcionários"); //Case 2: Exibe os dados cadastrados
            System.out.println("3 - Sair"); //Case 3: Saída

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\nDigite o nome do funcionário: ");
                    String nome = scanner.nextLine();

                    System.out.println("\nDigite o cpf do funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("\nDigite a data de nascimento: ");
                    String dataNascimento = scanner.nextLine();

                    System.out.println("Escolha o tipo de funcionário: ");
                    System.out.println("1 - Gerente: ");
                    System.out.println("2 - Desenvolvedor: ");
                    System.out.println("3 - Estagiário: ");

                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Funcionario novoFuncionario = null;

                    switch (tipo) { // Decidir o tipo dos funcionários
                        case 1:
                            novoFuncionario = new Gerente(cpf, dataNascimento, nome);
                        break;

                        case 2:
                            novoFuncionario = new Desenvolvedor(cpf, dataNascimento, nome);
                        break;

                        case 3:
                            novoFuncionario = new Estagiario(cpf, dataNascimento, nome);
                        break;

                        default:
                            novoFuncionario = null;
                            System.out.println("\nCargo inválido. Funcionário não cadastrado");
                        break;
                    }

                    if (novoFuncionario != null) { //Armazena os funcionários 
                        if (funcionario1 == null) {
                            funcionario1 = novoFuncionario;
                        } else if (funcionario2 == null) {
                            funcionario2 = novoFuncionario;
                        } else if (funcionario3 == null) {
                            funcionario3 = novoFuncionario;
                        } else {
                            System.out.println("\nLimite atingido de funcionário cadastrados");
                        }
                    }
                break;

                case 2:
                    System.out.println("\nExibindo funcionários"); //Exibe os funcionários
                    if (funcionario1 != null) {
                        funcionario1.mostrarDadosFuncionario();
                    }
                    if (funcionario2 != null) {
                        funcionario2.mostrarDadosFuncionario();
                    }
                    if (funcionario3 != null) {
                        funcionario3.mostrarDadosFuncionario();
                    }
                    if (funcionario1 == null && funcionario2 == null && funcionario3 == null) {
                        System.out.println("Nenhum funcionário está cadastrado.");
                    }
                break;

                case 3:
                    System.out.println("\nVocê saiu do programa");
                break;

                default: //Caso o usuário digite uma opção inválida
                    System.out.println("\nOpção inválida, tente novamente");
                break;
            }
        } while(op != 3); //Fecha o do
        scanner.close(); //Fecha o Scanner
    }
}
