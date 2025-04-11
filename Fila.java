public class Fila {

    Node head;
    Node tail;
    int quantidade;
    int tamanho;

    public Fila(int tamanhoMaximo) {
        this.tamanho = tamanhoMaximo;
        this.quantidade = 0;
    }

    public void addPersonagem(Personagens personagem) {
        if (quantidade < tamanho) {
            Node newNode = new Node(personagem);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            quantidade++;
        } else {
            System.out.println("A quantidade de personagens atingiu o limite máximo");
        }
    }

    public void removerPersonagem() {
        if (head == null) {
            System.out.println("Não há personagens criados");
        } else if (head == tail) {
            head = null;
            tail = null;
            quantidade--;
        } else {
            head = head.next;
            quantidade--;
        }
    }

    public void listar() {
        if (head == null) {
            System.out.println("Não há personagens criados");
        } else {
            Node temp = head;
            int i = 0;
            while (temp != null) {
                Personagens p = (Personagens) temp.valor;
                System.out.println("[" + i + "] " + p.getNome());
                temp = temp.next;
                i++;
            }
        }
    }

    public Personagens getElementoPorIndice(int index) {
        if (index < 0 || index >= quantidade) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (Personagens) temp.valor;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean estaCheia() {
        return quantidade >= tamanho;
    }

    public boolean enfileirar(Personagens personagem) {
        if (quantidade < tamanho) {
            addPersonagem(personagem);
            return true;
        }
        return false;
    }
    public void exibir() {
        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
    
        Node aux = head;
        while (aux != null) {
            Personagens p = (Personagens) aux.valor;
            System.out.println("- " + p.getNome() + " (HP: " + p.getVidaAtual() + "  Nível: " + p.getNivel() + "  Mana: " + p.getManaAtual() + "  Id(personagem): " + p.getIdPersonagem() + ")");
            aux = aux.next;
        }
    }
    public Personagens desenfileirar() {
        if (isEmpty()) {
            return null;
        }
        Personagens personagem = (Personagens) head.valor;
        removerPersonagem();
        return personagem;
    }

    public Personagens espiar() {
        if (isEmpty()) {
            return null;
        }
        return (Personagens) head.valor;
    }
}
