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

        Processo menor = Collections.min(
                fila,
                Comparator.comparingInt(
                        Processo::getQuantidadeInstrucoes
                )
        );

        fila.remove(menor);

        return menor;
    }

    private Processo roundRobin(Queue<Processo> fila) {
        return fila.poll();
    }
}