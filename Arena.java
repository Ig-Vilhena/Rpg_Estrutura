public class Arena {
    

import Personagens.Personagem;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    private Personagem jogador;
    private Personagem inimigo;
    private Scanner sc;

    public Arena(Personagem jogador, Personagem inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.sc = new Scanner(System.in);
    }

    public void iniciarBatalha() {
        System.out.println("\n Arena de Batalha ");
        System.out.println(jogador.getNome() + " VS " + inimigo.getNome());

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            turnoJogador();
            if (!inimigo.estaVivo()) break;

            turnoInimigo();
        }

        if (jogador.estaVivo()) {
            System.out.println("\n🏆 " + jogador.getNome() + " venceu a batalha!");
            jogador.subirNivel();
        } else {
            System.out.println("\n💀 " + jogador.getNome() + " foi derrotado.");
        }
    }

    private void turnoJogador() {
        System.out.println("\nSeu turno!");
        System.out.println("1. Atacar inimigo");
        System.out.println("2. Curar-se");
        System.out.print("Escolha: ");
        String escolha = sc.nextLine();

        switch (escolha) {
            case "1":
                inimigo.receberDano(jogador.getNivel()); // usa o nível como base pro dano
                break;
            case "2":
                jogador.curar(20); // cura padrão de 20
                break;
            default:
                System.out.println("Ação inválida. Você perdeu o turno!");
        }
    }

    private void turnoInimigo() {
        System.out.println("\nTurno do inimigo: " + inimigo.getNome());

        Random random = new Random();
        int acao = random.nextInt(2); // 0 = atacar, 1 = curar

        if (acao == 0) {
            jogador.receberDano(inimigo.getNivel());
        } else {
            inimigo.curar(10);
        }
    }
}






    
}
