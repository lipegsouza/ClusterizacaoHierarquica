import java.util.Random;

// Classe abstrata que possui implementados os métodos comuns aos dois tipos de clusterização
abstract class Clusterizacao {

    // Método para gerar os pontos iniciais e os colocar em seus clusters individuais
    protected Cluster[] geraPontos(int n) {
        Random random = new Random();
        Cluster[] clusters = new Cluster[n];

        for (int i = 0; i < n; i++) {
            // Gera as coordenadas aleatoriamente no intervalo de 1 a n
            int x1 = random.nextInt(n) + 1;
            int x2 = random.nextInt(n) + 1;
            // Cria um novo cluster a partir de um novo ponto com as coordenadas que acabaram de ser geradas
            clusters[i] = new Cluster(new Cluster.Ponto(x1, x2));
        }

        return clusters;
    }

    // Método para calcular o tempo de execução de um algoritmo de clusterização implementado no método clusteriza
    protected void calculaTempo(int n) {

        long t0Milli = System.currentTimeMillis();
        // Se o tempo em milissegundos for menor que 1, o tMilli vai retornar 0. Por isso, calcula-se também em nanossegundos
        long t0Nano = System.nanoTime();

        for(int i = 0; i<10; i++) {
            // Método clusteriza é chamado para um array com n clusters a ser gerado no método geraPontos
            clusteriza(geraPontos(n));
        }

        long t1Milli = System.currentTimeMillis();
        long t1Nano = System.nanoTime();

        double tMilli = (double) (t1Milli - t0Milli) / 10;
        double tNano = (double) (t1Nano - t0Nano) / 10;
        // Converte-se o tNano para milissegundos, para que seja mostrado caso necessário
        tNano = tNano / 1000000;

        String s;

        // Se o tMilli for 0, vai ser mostrado o valor convertido de nanossegundos, que vai estar entre 0 e 1
        if(tMilli > 0) {
            s = String.format("%.2f", tMilli);
        }
        else {
            s = String.format("%.2f", tNano);
        }

        System.out.println("Clusterizacao de " + n + " pontos artificiais");
        System.out.println("Tempo medio em milissegundos: " + s);
    }

    // Método abstrato que indica onde deve ser implementado o algoritmo de clusterização pelas subclasses
    abstract void clusteriza(Cluster[] clusters);
}