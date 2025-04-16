import java.util.Scanner;
import java.util.Random;

public class Arena {

    private int idBatalha;
    private Fila filaTurnos;
    private Pilha pilhaRanking;
    private int turnoAtual;
    private String estadoBatalha;

    public Arena(int idBatalha, Fila participantes) {
        this.idBatalha = idBatalha;
        this.filaTurnos = participantes;
        this.pilhaRanking = new Pilha(participantes.quantidade);
        this.turnoAtual = 1;
        this.estadoBatalha = "Em andamento";
    }

    public Arena(){
        
    }

    public void iniciarBatalha() {
        System.out.println("\n===== INICIANDO BATALHA ID " + idBatalha + " =====");
        System.out.println("Participantes:");
    
        filaTurnos.exibir();

        while (estadoBatalha.equals("Em andamento")) {
            executarTurno();
            verificarVencedor();
        }

        exibirRankingFinal();
    }

    public void executarTurno() {
        System.out.println("\n===== TURNO " + turnoAtual + " =====");

        Personagens atual = filaTurnos.desenfileirar();

        if (atual != null && atual.estaVivo()) {
            realizarAcao(atual);
            filaTurnos.enfileirar(atual);
        } else if (atual != null) {
            pilhaRanking.empilhar(atual);
            System.out.println(atual.getNome() + " foi derrotado!");
        }

        turnoAtual++;
    }

    private void realizarAcao(Personagens personagem) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Vez de: " + personagem.getNome());
        
        System.out.println("1. Atacar");
        System.out.println("2. Curar-se");
        System.out.print("Escolha: ");
        String escolha = sc.nextLine();
        
        if (escolha.equals("1")) {
            Personagens alvo = filaTurnos.espiar();
            alvo.receberDano(personagem.getNivel());
            System.out.println(personagem.getNome() + " atacou " + alvo.getNome());
        } else if (escolha.equals("2")) {
            personagem.curar(10);
            System.out.println(personagem.getNome() + " se curou");
        } else {
            System.out.println("Ação inválida. Perdeu o turno.");
        }
    }

    public void verificarVencedor() {
        int vivos = 0;
        Personagens ultimoVivo = null;

        Node temp = filaTurnos.head;
        while (temp != null) {
            Personagens p = (Personagens) temp.valor;
            if (p.estaVivo()) {
                vivos++;
                ultimoVivo = p;
            }
            temp = temp.next;
        }

        if (vivos <= 1) {
            estadoBatalha = "Finalizada";
            if (ultimoVivo != null) {
                pilhaRanking.empilhar(ultimoVivo);
                System.out.println("\n" + ultimoVivo.getNome() + " venceu a batalha!");
                ultimoVivo.subirNivel();
            }
        }
    }

    public void exibirRankingFinal() {
        System.out.println("\n===== RANKING FINAL =====");
        pilhaRanking.exibir();
    }
}
