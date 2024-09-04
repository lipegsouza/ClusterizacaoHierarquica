public class Main {
    public static void main(String[] args) {

        System.out.println("Naive: ");
        ClusterizacaoNaive n = new ClusterizacaoNaive();
        n.calculaTempo(10);
        System.out.println();
        n.calculaTempo(20);
        System.out.println();
        n.calculaTempo(30);
        System.out.println();
        n.calculaTempo(40);
        System.out.println();
        n.calculaTempo(50);
        System.out.println();
        n.calculaTempo(100);
        System.out.println();
        n.calculaTempo(200);
        System.out.println();
        n.calculaTempo(500);
        System.out.println();
        n.calculaTempo(1000);
        System.out.println();
        n.calculaTempo(5000);
        System.out.println();
        n.calculaTempo(10000);
        System.out.println();
        n.calculaTempo(20000);
        System.out.println();
        n.calculaTempo(50000);
        System.out.println();
        n.calculaTempo(100000);


        System.out.println("--------------------------");
        System.out.println("Fila de prioridade: ");
        ClusterizacaoFila f = new ClusterizacaoFila();
        f.calculaTempo(10);
        System.out.println();
        f.calculaTempo(20);
        System.out.println();
        f.calculaTempo(30);
        System.out.println();
        f.calculaTempo(40);
        System.out.println();
        f.calculaTempo(50);
        System.out.println();
        f.calculaTempo(100);
        System.out.println();
        f.calculaTempo(200);
        System.out.println();
        f.calculaTempo(500);
        System.out.println();
        f.calculaTempo(1000);
        System.out.println();
        f.calculaTempo(5000);
        System.out.println();
        f.calculaTempo(10000);
        System.out.println();
        f.calculaTempo(20000);
        System.out.println();
        f.calculaTempo(50000);
        System.out.println();
        f.calculaTempo(100000);
    }
}
