// Superclasse
class Funcionario {
    void mostrarDados() {
        System.out.println("Mostrando os dados do funcionário");
    }

    void baterPonto() {
        System.out.println("Funcionário bateu ponto");
    }
}

// Subclasse Gerente
class Gerente extends Funcionario {
    @Override
    void mostrarDados() {
        System.out.println("Mostrando os dados do gerente");
    }

    void realizarReuniao() {
        System.out.println("Gerente está relizando reunião");
    }
}

// Subclasse Desenvolvedor
class Desenvolvedor extends Funcionario {
    @Override
    void mostrarDados() {
        System.out.println("Mostrando os dados do desenvolvedor");
    }

    void programar() {
        System.out.println("O desenvolvedor está programando");
    }
}

// Subclasse Estagiario
class Estagiario extends Funcionario {
    @Override
    void mostrarDados() {
        System.out.println("Mostrando os dados do estagiário");
    }

    void fazerTarefa() {
        System.out.println("O estagiário está realizando tarefas");
    }
}

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        Estagiario estagiario = new Estagiario();

        System.out.println(" ");

        gerente.mostrarDados();
        gerente.baterPonto();
        gerente.realizarReuniao();

        System.out.println(" ");

        desenvolvedor.mostrarDados();
        desenvolvedor.baterPonto();
        desenvolvedor.programar();

        System.out.println(" ");

        estagiario.mostrarDados();
        estagiario.baterPonto();
        estagiario.fazerTarefa();

        System.out.println(" ");
    }
}
