public class Arvbin {
    public Cluster val;
    Arvbin esq;
    Arvbin dir;

    public Arvbin(Cluster valor) {
        this.val = valor;
        this.esq = null;
        this.dir = null;
    }

    public Arvbin(Cluster valor, Arvbin arvEsq, Arvbin arvDir) {
        this.val = valor;
        this.esq = arvEsq;
        this.dir = arvDir;
    }

    public void mostra() {
        System.out.print("(" + val);
        if (esq != null) {
            esq.mostra();
        }
        if (dir != null) {
            dir.mostra();
        }
        System.out.print(")");
    }
}
