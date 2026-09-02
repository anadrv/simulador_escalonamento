import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;

public class AlgoritmoEscalonamento {

    public Processo escolherProcesso(
            Queue<Processo> fila,
            Escalonador.Algoritmo tipo
    ) {

        if (fila.isEmpty()) {
            return null;
        }

        switch (tipo) {

            case FCFS:
                return fcfs(fila);

            case SJF:
                return sjf(fila);

            case ROUND_ROBIN:
                return roundRobin(fila);

            default:
                return null;
        }
    }

    private Processo fcfs(Queue<Processo> fila) {
        return fila.poll();
    }

    private Processo sjf(Queue<Processo> fila) {


        System.out.println(
                "\u001B[38;5;218m✰ Fila de processos: \u001B[0m"
        );

        for (Processo processo : fila) {
            System.out.println(
                    "P" + processo.getId()
                            + " - "
                            + processo.getQuantidadeInstrucoes()
                            + " instruções restantes"
            );
        }

        System.out.println();

        Processo menor = Collections.min(
                fila,
                Comparator.comparingInt(
                        Processo::getQuantidadeInstrucoes
                )
        );


        fila.remove(menor);

        System.out.println(
                "✰ Processo escolhido pelo SJF: P"
                        + menor.getId()
                        + " - "
                        + menor.getQuantidadeInstrucoes()
                        + " instruções"
        );

        return menor;
    }

    private Processo roundRobin(Queue<Processo> fila) {
        return fila.poll();
    }
}