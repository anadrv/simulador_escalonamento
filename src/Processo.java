public class Processo {

    private int id;
    private int quantidadeInstrucoes;

    public Processo(int id, int quantidadeInstrucoes) {
        this.id = id;
        this.quantidadeInstrucoes = quantidadeInstrucoes;
    }

    public int getId() {
        return id;
    }

    public int getQuantidadeInstrucoes() {
        return quantidadeInstrucoes;
    }

    public void executar() {
        if (quantidadeInstrucoes > 0) {
            quantidadeInstrucoes--;
        }
    }

    public boolean isFinalizado() {
        return quantidadeInstrucoes == 0;
    }

}