import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ESCALONAMENTO DE PROCESSOS");
        System.out.println();

        System.out.println("1 - FCFS");
        System.out.println("2 - SJF");
        System.out.println("3 - Round Robin");
        System.out.println();

        System.out.print("Escolha o algoritmo: ");

        int opcao = scanner.nextInt();

        Escalonador.Algoritmo algoritmo;
        int quantum = 0;

        switch (opcao) {

            case 1:
                algoritmo = Escalonador.Algoritmo.FCFS;
                break;

            case 2:
                algoritmo = Escalonador.Algoritmo.SJF;
                break;

            case 3:
                algoritmo = Escalonador.Algoritmo.ROUND_ROBIN;

                System.out.print("Digite o quantum: ");
                quantum = scanner.nextInt();

                if (quantum <= 0) {
                    System.out.println(
                            "O quantum deve ser maior que zero."
                    );

                    scanner.close();
                    return;
                }

                break;

            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        System.out.println();
        System.out.println(
                "Algoritmo escolhido: " + algoritmo
        );

        if (algoritmo == Escalonador.Algoritmo.ROUND_ROBIN) {
            System.out.println("Quantum: " + quantum);
        }

        System.out.println();

        GeradorDeProcessos gerador =
                new GeradorDeProcessos();

        Escalonador escalonador =
                new Escalonador();

        AlgoritmoEscalonamento algoritmos =
                new AlgoritmoEscalonamento();

        CPU cpu =
                new CPU(
                        escalonador,
                        gerador,
                        algoritmos,
                        algoritmo,
                        quantum
                );

        cpu.executar();

        scanner.close();
    }
}