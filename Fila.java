package Jogadores;
import Personagens.Personagens;
public class Fila {
    
    Node head;
    Node tail;
    int quantidade;
    int tamanho;
    
    public Fila(int tamanhoMaximo){
        this.tamanho = tamanhoMaximo;
        quantidade =0;
    }

    public void addPersonagem(Personagens Personagens){
        if (quantidade< tamanho) {
            Node newNode = new Node(null);
            if (head == null) {
                head = newNode; 
                tail = newNode;
                quantidade++;
                return;
                
            }else{
                tail = newNode;
                newNode = tail;
                tail = newNode;
                quantidade++;
                return;
            }
        }else{
            System.out.println("A quantidade de personagens atingiu limite maximo");
        } 
    }
    public void removerPersonagem(){
        if (head == null) {
            System.out.println("Nao há personagens criados");
        }if (head == tail) {
            head = null;
            tail = null;
            quantidade--;
            return;
            
        }else{
            Node temp = head.next;

            head.next =null;
            head = temp;
            quantidade--;
            return;
        }
    }
    public void personagens(){
        if (head == null) {
            System.out.println("Nao ha personagens criados");
        }else{

        }
    }

    public boolean isEmpty(){
        if (head ==null) {
            return true;
            
        }else{
            return false;

        }
    }
    public boolean isFull(){
        if (quantidade<= tamanho) {
            return true;
        }else{
            return false;
        }
    }
}
