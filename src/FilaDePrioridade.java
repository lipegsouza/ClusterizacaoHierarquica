import java.util.Arrays;

public class FilaDePrioridade {
    private int numeroClusters;
    private int tamanhoFila;
    Distancia[] vetor;

    public FilaDePrioridade(int numeroClusters, Distancia[] v) {
        setNumeroClusters(numeroClusters);
        setTam();
        setVetor(new Distancia[getTamanhoFila() + 1]);

        if (getTamanhoFila() >= 0) System.arraycopy(v, 0, getVetor(), 1, getTamanhoFila());

        constroiHeap();
    }

    private void constroiHeap() {
        for (int i = getNumeroClusters() / 2; i > 0; i--) {
            refaz(i);
        }
    }

    private void refaz(int i) {
        Distancia x = getVetor()[i];

        while (2 * i <= getNumeroClusters()) {
            int menorFilho = getMenorFilho(i);

            if (getVetor()[menorFilho].getDistancia() < x.getDistancia())
                getVetor()[i] = getVetor()[menorFilho];
            else
                break;

            i = menorFilho;
        }

        getVetor()[i] = x;
    }

    private int getMenorFilho(int i) {
        int filhoEsq, filhoDir, menorFilho;

        filhoEsq = 2 * i;
        filhoDir = 2 * i + 1;

        menorFilho = filhoEsq;

        if (filhoDir <= getNumeroClusters()) {
            if (getVetor()[filhoDir].getDistancia() < getVetor()[filhoEsq].getDistancia())
                menorFilho = filhoDir;
        }

        return menorFilho;
    }

    public void refazVetor(Distancia[] distancias) {
        Distancia menorDistancia = getVetor()[1];
        numeroClusters--;
        tamanhoFila -= numeroClusters;
        Distancia[] d = new Distancia[getTamanhoFila() + 1];

        // d vai ter nas primeiras posições as distancias novas
        System.arraycopy(distancias, 0, d, 1, distancias.length);

        // Index é o tamanho do vetor distancias para que o novo vetor tenha as distancias antigas depois das novas
        int index = distancias.length;
        // Adiciona ao novo vetor de distancia apenas as que não estão relacionadas a menor distancia, que vai ser removida ao ser ignorada aqui
        for (int i = 1; i < getVetor().length; i++) {
            if (getVetor()[i].naoIgual(menorDistancia.getCluster1()) && getVetor()[i].naoIgual(menorDistancia.getCluster2())) {
                d[++index] = getVetor()[i];
            }
        }

        vetor = d;

        if (getVetor().length > 2) {
            constroiHeap();
        }
    }

    // Getters, Setters e toString
    public void setNumeroClusters(int numeroClusters) {
        this.numeroClusters = numeroClusters;
    }

    public int getNumeroClusters() {
        return numeroClusters;
    }

    public void setVetor(Distancia[] vetor) {
        this.vetor = vetor;
    }

    public Distancia[] getVetor() {
        return vetor;
    }

    public void setTam() {
        this.tamanhoFila = (getNumeroClusters() * (getNumeroClusters() - 1)) / 2;
    }

    public int getTamanhoFila() {
        return tamanhoFila;
    }

    @Override
    public String toString() {
        return "HeapBinariaMinimaCluster{" +
                "n=" + getNumeroClusters() +
                ", tam=" + getTamanhoFila() +
                ", vetor=" + Arrays.toString(getVetor()) +
                '}';
    }
}