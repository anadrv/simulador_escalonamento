import java.util.*;

public class Escalonador {


    public enum Algoritmo {
        FCFS,
        SJF,
        ROUND_ROBIN
    }

    private Algoritmo algoritmo;

    private int quantum = 2;

    private Queue<Processo> filaProntos;

    public Escalonador(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
        this.filaProntos = new LinkedList<>();
    }

    public void adicionarProcesso(Processo processo) {
        filaProntos.add(processo);
    }

    public Processo proximoProcesso() {

        if (filaProntos.isEmpty()) {
            return null;
        }

        switch (algoritmo) {

            case FCFS:
                return executarFCFS();

            case SJF:
                return executarSJF();

            case ROUND_ROBIN:
                return executarRoundRobin();

            default:
                return null;
        }
    }

    private Processo executarFCFS() {
        return filaProntos.poll();
    }

    private Processo executarSJF() {

        Processo menor = Collections.min(
                filaProntos,
                Comparator.comparingInt(Processo::getTempoExecucao)
        );

        filaProntos.remove(menor);

        return menor;
    }

    private Processo executarRoundRobin() {

        Processo processo = filaProntos.poll();

        if (processo != null) {
            processo.executar(quantum);

            if (!processo.terminou()) {
                filaProntos.add(processo);
            }
        }

        return processo;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {

        if (quantum <= 0) {
            throw new IllegalArgumentException(
                    "O quantum deve ser maior que zero."
            );
        }

        this.quantum = quantum;
    }

    public Algoritmo getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
    }
}