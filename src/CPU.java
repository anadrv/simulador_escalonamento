public class CPU {

    private Escalonador escalonador;
    private GeradorDeProcessos gerador;
    private AlgoritmoEscalonamento algoritmos;

    private Escalonador.Algoritmo algoritmo;
    private int quantum;

    public CPU(
            Escalonador escalonador,
            GeradorDeProcessos gerador,
            AlgoritmoEscalonamento algoritmos,
            Escalonador.Algoritmo algoritmo,
            int quantum
    ) {
        this.escalonador = escalonador;
        this.gerador = gerador;
        this.algoritmos = algoritmos;
        this.algoritmo = algoritmo;
        this.quantum = quantum;
    }

    public void executar() {

        Processo processoAtual = null;
        int ciclosQuantum = 0;
        int ciclo = 1;

        Processo primeiroProcesso = gerador.gerarProcesso();
        escalonador.adicionarProcesso(primeiroProcesso);

        while (true) {

            System.out.println();
            System.out.println("- CICLO " + ciclo + " -");

            if (gerador.deveGerarProcesso()) {

                Processo novoProcesso =
                        gerador.gerarProcesso();

                escalonador.adicionarProcesso(novoProcesso);

                System.out.println(
                        "Novo processo: P"
                                + novoProcesso.getId()
                                + " | Instruções: "
                                + novoProcesso.getQuantidadeInstrucoes()
                );
            }

            if (processoAtual == null) {

                processoAtual = algoritmos.escolherProcesso(
                        escalonador.getFilaProntos(),
                        algoritmo
                );

                ciclosQuantum = 0;
            }

            if (processoAtual == null) {

                System.out.println("CPU ociosa.");

            } else {

                System.out.println(
                        "Executando processo P"
                                + processoAtual.getId()
                );

                processoAtual.executar();

                System.out.println(
                        "Instruções restantes: "
                                + processoAtual.getQuantidadeInstrucoes()
                );

                ciclosQuantum++;

                if (processoAtual.isFinalizado()) {

                    System.out.println(
                            "Processo P"
                                    + processoAtual.getId()
                                    + " finalizado!"
                    );

                    processoAtual = null;
                    ciclosQuantum = 0;

                } else if (
                        algoritmo ==
                                Escalonador.Algoritmo.ROUND_ROBIN
                                && ciclosQuantum >= quantum
                ) {

                    System.out.println(
                            "Quantum encerrado para P"
                                    + processoAtual.getId()
                    );

                    escalonador.adicionarProcesso(processoAtual);

                    processoAtual = null;
                    ciclosQuantum = 0;
                }
            }

            ciclo++;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}