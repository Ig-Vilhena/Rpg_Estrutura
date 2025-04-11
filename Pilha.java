public class Pilha {

    Node topo;
    int quantidade;
    int tamanho;

    public Pilha(int tamanhoMaximo) {
        this.tamanho = tamanhoMaximo;
        this.quantidade = 0;
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public boolean estaCheia() {
        return quantidade >= tamanho;
    }

    public void empilhar(Personagens valor) {
        Node newNode = new Node(valor);
        newNode.next = topo;
        topo = newNode;
        tamanho++;
    }
    

    public void push(Personagens personagem) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia");
            return;
        }

        Node newNode = new Node(personagem);
        newNode.next = topo;
        topo = newNode;
        quantidade++;
    }

    public Personagens pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia");
            return null;
        }

        Personagens personagem = (Personagens) topo.valor;
        topo = topo.next;
        quantidade--;
        return personagem;
    }

    public Personagens peek() {
        if (isEmpty()) {
            return null;
        }
        return (Personagens) topo.valor;
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia");
            return;
        }

        Node temp = topo;
        while (temp != null) {
            Personagens p = (Personagens) temp.valor;
            System.out.println(p);
            temp = temp.next;
        }
    }
}
