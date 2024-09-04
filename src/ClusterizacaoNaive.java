public class ClusterizacaoNaive extends Clusterizacao {

    @Override
    void clusteriza(Cluster[] clusters) {
        int n = clusters.length;

        // Loop que executa o algoritmo até que sobre apenas um cluster
        while (n > 1) {
            double menorDistancia = Double.MAX_VALUE;
            int cluster1 = -1;
            int cluster2 = -1;

            // Percorre todos os pares de clusters para encontrar os dois mais próximos
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double distancia = clusters[i].calculaDistancia(clusters[j]);
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        cluster1 = i;
                        cluster2 = j;
                    }
                }
            }

            // Cria um novo cluster a partir dos dois mais próximos encontrados
            Cluster novoCluster = new Cluster(clusters[cluster1], clusters[cluster2]);

            // Remove os clusters anteriores e decrementa o número de clusters a serem considerados no array
            clusters[cluster1] = novoCluster;
            clusters[cluster2] = clusters[n - 1];
            n--;
        }
        //clusters[0].getArvore().mostra();
    }
}