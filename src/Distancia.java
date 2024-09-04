public class Distancia {
    private Cluster cluster1, cluster2;
    private double distancia;

    public Distancia(Cluster c1, Cluster c2) {
        setCluster1(c1);
        setCluster2(c2);
        setDistancia(getCluster1(),getCluster2());
    }

    public boolean naoIgual(Cluster c) {
        return cluster1 != c && cluster2 != c;
    }

    // Getters, Setters e toString
    public void setCluster1(Cluster cluster1) {
        this.cluster1 = cluster1;
    }

    public void setCluster2(Cluster cluster2) {
        this.cluster2 = cluster2;
    }

    public void setDistancia(Cluster c1, Cluster c2) {
        this.distancia = c1.calculaDistancia(c2);
    }

    public Cluster getCluster1() {
        return cluster1;
    }

    public Cluster getCluster2() {
        return cluster2;
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return "DistanciaCluster{" +
                "cluster1=" + getCluster1() +
                ", cluster2=" + getCluster2() +
                ", distancia=" + getDistancia() +
                '}';
    }
}