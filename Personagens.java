package Personagens;
import java.util.LinkedList;
import java.util.Random;
import java.util.Random;
import java.util.UUID;

public class Personagens {

    private String idPersonagem;
    private String nome;
    private int xp = 0;
    private int nivel;
    private int vidaMaxima;
    private int vidaAtual;
    private int manaMaxima;
    private int manaAtual;
    private LinkedList<String> Habilidades;

    public Personagens(String nome, int nivel, int vidaMaxima, int vidaAtual, int manaMaxima,
            int manaAtual) {
        this.idPersonagem = UUID.randomUUID().toString();

        this.nome = nome;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaAtual;
        this.Habilidades = new LinkedList<>();
    }

    public String getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(String idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    // --------------------------------------------------------//

    public void receberDano(int valor) {
        Random rand = new Random(valor);
        int dano = rand.nextInt(15) + 5;
        vidaAtual -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano\n");
        System.out.println("Vida atual: " + vidaAtual);

    }

    public void usarHabilidade(int idHabilidade, Personagens alvo) {
  
    }


    public void curar(int valor) {
        valor += vidaAtual;
        if (vidaAtual> vidaMaxima) {
            vidaAtual = vidaMaxima;
            System.out.println(nome+ " foi curado " + valor );
            System.out.println("Vida atual: " + vidaAtual);
            
        }
    }

    public boolean estaVivo() {
        if (vidaAtual <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void subirNivel() {

        if (nivel<20) {
            nivel++;
        vidaMaxima+= 20;
        manaMaxima +=20;
        vidaAtual = vidaMaxima;
        System.out.println(nome + " subiu de nível.\n Nível atual: " + nivel );
 
        } else if(nivel <10){
            nivel++;
            vidaMaxima+= 15;
            manaMaxima +=15;
            vidaAtual = vidaMaxima;
            System.out.println(nome + " subiu de nível.\n Nível atual: " + nivel );
        }else if (nivel <5){
            nivel++;
            vidaMaxima+= 10;
            manaMaxima += 10;
            vidaAtual = vidaMaxima;
            System.out.println(nome + " subiu de nível.\n Nível atual: " + nivel );
        }        
    }
}
