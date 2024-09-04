public class ClusterizacaoFila extends Clusterizacao {

    @Override
    void clusteriza(Cluster[] clusters) {
        int n = clusters.length;
        // O array de distancias tem o tamanho calculado a partir da fórmula de combinações de pares únicos
        Distancia[] dc = new Distancia[(n * (n - 1)) / 2];
        int index = 0;

        // Calcula as distâncias entre todos os pares de clusters e as armazena no array de distancias
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dc[index++] = new Distancia(clusters[i], clusters[j]);
            }
        }

        FilaDePrioridade heap = new FilaDePrioridade(n ,dc);

        // Loop que executa o algoritmo até que sobre apenas um cluster
        while(n > 1) {
            // A menor distância é sempre a primeira na heap
            Distancia menorDistancia = heap.vetor[1];
            // Cria um novo cluster a partir dos dois que compõem a menor distancia
            Cluster novoCluster = new Cluster(menorDistancia.getCluster1(), menorDistancia.getCluster2());

            // Array para armazenar o novo cluster e todos os outros que não os dois usados na criação do novo
            Cluster[] c = new Cluster[n-1];
            // Array para armazenar as novas distâncias que devem ser calculadas devido ao novo cluster
            Distancia[] d = new Distancia[n-2];

            index=0;
            c[index] = novoCluster;
            for(int i=0; i<n; i++) {
                if(menorDistancia.naoIgual(clusters[i])) {
                    // Armazena no d a distância do novo cluster para todos os outros que não os dois usados na criação dele
                    d[index] = new Distancia(novoCluster, clusters[i]);
                    // Armazena no c todos os clusters que não os dois usados na criação do novo
                    c[++index] = clusters[i];
                }
            }

            // Atualiza o array de clusters, decrementa o número de clusters e reconstroi a heap
            clusters = c;
            n--;
            heap.refazVetor(d);
        }
        clusters[0].getArvore().mostra();
    }
}