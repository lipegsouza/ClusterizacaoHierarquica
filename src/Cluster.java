import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private Ponto centroide;
    private List<Ponto> pontos;
    private double somaX1;
    private double somaX2;
    private Arvbin arvore;

    public static class Ponto {
        private double x1;
        private double x2;

        public Ponto(double x1, double x2) {
            setX1(x1);
            setX2(x2);
        }

        // Getters, Setters e toString
        public void setX1(double x1) {
            this.x1 = x1;
        }

        public void setX2(double x2) {
            this.x2 = x2;
        }

        public double getX1() {
            return x1;
        }

        public double getX2() {
            return x2;
        }

        @Override
        public String toString() {
            String x1 = String.format("%.2f", getX1());
            String x2 = String.format("%.2f", getX2());
            return "(" + x1 + ", " + x2 + ")";
        }
    }

    // Construtor que cria um cluster a partir de um ponto
    public Cluster(Ponto ponto) {
        setCentroide(ponto);
        setPontos(new ArrayList<>());
        setSomaX1(ponto.getX1());
        setSomaX2(ponto.getX2());
        setArvore(new Arvbin(this));
    }

    // Construtor que cria um cluster a partir de dois clusters
    public Cluster(Cluster c1, Cluster c2) {
        this.pontos = new ArrayList<>(c1.getPontos());
        this.pontos.addAll(c2.getPontos());
        this.somaX1 = c1.getSomaX1() + c2.getSomaX1();
        this.somaX2 = c1.getSomaX2() + c2.getSomaX2();
        this.centroide = new Ponto(getSomaX1() / getPontos().size(), getSomaX2() / getPontos().size());
        this.arvore = new Arvbin(this, c1.getArvore(), c2.getArvore());
    }

    // Método que calcula a distância euclidiana entre o cluster corrente e um Cluster c
    protected double calculaDistancia(Cluster c) {
        return Math.sqrt(Math.pow(this.getCentroide().getX1() - c.getCentroide().getX1(), 2) +
                Math.pow(this.getCentroide().getX2() - c.getCentroide().getX2(), 2));
    }

    // Getters, Setters e toString
    public void setCentroide(Ponto centroide) {
        this.centroide = centroide;
    }

    public Ponto getCentroide() {
        return centroide;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
        this.pontos.add(getCentroide());
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setArvore(Arvbin arvore) {
        this.arvore = arvore;
    }

    public Arvbin getArvore() {
        return arvore;
    }

    public void setSomaX1(double somaX1) {
        this.somaX1 = somaX1;
    }

    public double getSomaX1() {
        return somaX1;
    }

    public void setSomaX2(double somaX2) {
        this.somaX2 = somaX2;
    }

    public double getSomaX2() {
        return somaX2;
    }

    @Override
    public String toString() {
        return "Cluster: " + getCentroide().toString();
    }

}