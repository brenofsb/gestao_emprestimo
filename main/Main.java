package main;

import java.util.Scanner;
import java.time.LocalDate;

import carga.BateriaPortatil;
import centro.CentroRecursos;
import excessoes.CentroRecursosException;

public class Main {

    private static Scanner teclado = new Scanner(System.in);
    private static CentroRecursos centro = new CentroRecursos();

    public static void main(String[] args) {

        int opcao;
        boolean sair = false;

        while (!sair) {

            exibirMenu();
            opcao = lerInteiro();

            if (opcao == 11) {
                sair = true;
                System.out.println("Encerrando o sistema...");
            } else {
                executarOpcao(opcao);
            }
        }

        teclado.close();
    }

    public static void exibirMenu() {

        System.out.println("\n===== CENTRO DE RECURSOS =====");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Realizar empréstimo");
        System.out.println("3 - Registrar devolução");
        System.out.println("4 - Enviar equipamento para manutenção");
        System.out.println("5 - Encerrar manutenção");
        System.out.println("6 - Consultar empréstimos em aberto");
        System.out.println("7 - Operações com bateria");
        System.out.println("8 - Alterar departamento do professor");
        System.out.println("9 - Consultar/alterar prazos de empréstimo");
        System.out.println("10 - Consultar/alterar limites de usuários");
        System.out.println("11 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void executarOpcao(int opcao) {

        try {
            switch (opcao) {

                case 1:
                    menuCadastro();
                    break;

                case 2:
                    realizarEmprestimo();
                    break;

                case 3:
                    registrarDevolucao();
                    break;

                case 4:
                    enviarManutencao();
                    break;

                case 5:
                    encerrarManutencao();
                    break;

                case 6:
                    consultarEmprestimos();
                    break;

                case 7:
                    menuBateria();
                    break;

                case 8:
                    alterarDepartamento();
                    break;

                case 9:
                    menuPrazos();
                    break;

                case 10:
                    menuLimites();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void menuCadastro() {

        System.out.println("\n===== CADASTRO =====");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Cadastrar professor");
        System.out.println("3 - Cadastrar notebook");
        System.out.println("4 - Cadastrar projetor");
        System.out.println("5 - Cadastrar câmera digital");
        System.out.println("6 - Cadastrar bateria portátil");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = lerInteiro();

        switch (opcao) {

            case 1:
                cadastrarAluno();
                break;

            case 2:
                cadastrarProfessor();
                break;

            case 3:
                cadastrarNotebook();
                break;

            case 4:
                cadastrarProjetor();
                break;

            case 5:
                cadastrarCamera();
                break;

            case 6:
                cadastrarBateria();
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void cadastrarAluno() {

        // Solicitar dados do aluno
        // Chamar método do CentroRecursos
    }

    public static void cadastrarProfessor() {

        // Solicitar dados do professor
        // Chamar método do CentroRecursos
    }

    public static void cadastrarNotebook() {

        // Solicitar dados do notebook
        // Chamar método do CentroRecursos
    }

    public static void cadastrarProjetor() {

        // Solicitar dados do projetor
        // Chamar método do CentroRecursos
    }

    public static void cadastrarCamera() {

        // Solicitar dados da câmera
        // Chamar método do CentroRecursos
    }

    public static void cadastrarBateria() {

        try {
            System.out.print("Código da bateria: ");
            String codigo = teclado.nextLine();

            System.out.print("Carga inicial (%): ");
            double carga = lerDouble();

            BateriaPortatil bateria = new BateriaPortatil(codigo, carga);

            // Exibir dados da bateria cadastrada
            System.out.println("Bateria criada: " + bateria.cCodigo());
            System.out.println("Carga atual: " + bateria.cCarga() + "%");

            // Registrar bateria no CentroRecursos

        } catch (CentroRecursosException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void realizarEmprestimo() {

        // Solicitar código do usuário
        // Solicitar código do equipamento
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void registrarDevolucao() {

        // Solicitar código do equipamento
        // Solicitar data de devolução
        // Solicitar se precisa de reparo
        // Solicitar percentual de carga, quando aplicável
        // Chamar método do CentroRecursos
        // Exibir quantidade de dias de atraso
    }

    public static void enviarManutencao() {

        // Solicitar código do equipamento
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void encerrarManutencao() {

        // Solicitar código do equipamento
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void consultarEmprestimos() {

        // Consultar empréstimos em aberto
        // Exibir resultado
    }

    public static void menuBateria() {

        System.out.println("\n===== OPERAÇÕES COM BATERIA =====");
        System.out.println("1 - Consultar carga");
        System.out.println("2 - Consultar tempo para carga completa");
        System.out.println("3 - Carregar por tempo");
        System.out.println("4 - Alterar percentual de carga");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = lerInteiro();

        switch (opcao) {

            case 1:
                consultarCarga();
                break;

            case 2:
                consultarTempoCarga();
                break;

            case 3:
                carregarPorTempo();
                break;

            case 4:
                alterarCargaPercentual();
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void consultarCarga() {

        // Solicitar código da bateria
        // Consultar carga no CentroRecursos
        // Exibir resultado
    }

    public static void consultarTempoCarga() {

        // Solicitar código da bateria
        // Consultar tempo no CentroRecursos
        // Exibir resultado
    }

    public static void carregarPorTempo() {

        // Solicitar código da bateria
        // Solicitar tempo de carga
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void alterarCargaPercentual() {

        // Solicitar código da bateria
        // Solicitar percentual de carga
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void alterarDepartamento() {

        // Solicitar código do professor
        // Solicitar novo departamento
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void menuPrazos() {

        // Consultar ou alterar prazos de empréstimo
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static void menuLimites() {

        // Consultar ou alterar limites de usuários
        // Chamar método do CentroRecursos
        // Exibir resultado
    }

    public static int lerInteiro() {

        while (true) {
            try {
                return Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {
                System.out.print("Digite um número inteiro válido: ");
            }
        }
    }

    public static double lerDouble() {

        while (true) {
            try {
                return Double.parseDouble(
                    teclado.nextLine().replace(",", ".")
                );

            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }
}
