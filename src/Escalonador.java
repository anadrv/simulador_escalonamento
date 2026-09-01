import java.util.LinkedList;
import java.util.Queue;

public class Escalonador {

    public enum Algoritmo {
        FCFS,
        SJF,
        ROUND_ROBIN
    }

    private Queue<Processo> filaProntos;

    public Escalonador() {
        filaProntos = new LinkedList<>();
    }

    public void adicionarProcesso(Processo processo) {
        filaProntos.add(processo);
    }

    public Queue<Processo> getFilaProntos() {
        return filaProntos;
    }

    public boolean possuiProcessos() {
        return !filaProntos.isEmpty();
    }
}