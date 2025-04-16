import java.util.LinkedList;
import java.util.UUID;

public class Personagens {

    private String idPersonagem;
    private String nome;
    private int nivel;
    private int vidaMaxima;
    private int vidaAtual;
    private int manaMaxima;
    private int manaAtual;
    private String tipo;
    private LinkedList<String> habilidades;

    public Personagens(String nome, int nivel, int vidaMaxima, int vidaAtual, int manaMaxima, int manaAtual) {
        this.idPersonagem = UUID.randomUUID().toString();
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaAtual;
        this.habilidades = new LinkedList<>();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void adicionarHabilidade(String habilidade) {
        habilidades.add(habilidade);
    }

    public void receberDano(int valor) {
        vidaAtual -= valor;
        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
        System.out.println(nome + " recebeu " + valor + " de dano.");
        System.out.println("Vida atual: " + vidaAtual);
    }

    public void usarHabilidade(int idHabilidade, Personagens alvo) {
        if (idHabilidade >= 0 && idHabilidade < habilidades.size()) {
            String habilidade = habilidades.get(idHabilidade);
            System.out.println(nome + " usou " + habilidade + " em " + alvo.getNome());
            alvo.receberDano(10); 
        } else {
            System.out.println("Habilidade inválida.");
        }
    }

    public void curar(int valor) {
        vidaAtual += valor;
        if (vidaAtual > vidaMaxima) {
            vidaAtual = vidaMaxima;
        }
        System.out.println(nome + " foi curado em " + valor);
        System.out.println("Vida atual: " + vidaAtual);
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void subirNivel() {
        nivel++;
        vidaMaxima += 20;
        manaMaxima += 20;
        vidaAtual = vidaMaxima;
        manaAtual = manaMaxima;
        System.out.println(nome + " subiu de nível! Nível atual: " + nivel);
    }
}
