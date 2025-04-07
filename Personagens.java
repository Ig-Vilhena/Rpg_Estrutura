package Personagens;

import java.util.random.*;
import java.util.UUID;

public class Personagens {

    private String idPersonagem;
    private String nome;
    private int nivel;
    private int vidaMaxima;
    private int vidaAtual;
    private int manaMaxima;
    private int manaAtual;

    public Personagens(String nome, int nivel, int vidaMaxima, int vidaAtual, int manaMaxima,
            int manaAtual) {
        this.idPersonagem = UUID.randomUUID().toString();
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaAtual;
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
        double random = Math.random() * +1;
        System.out.println(random);
    }

    public void usarHabilidade(int idHabilidade) {

    }

    public void curar(int valor) {

    }

    public boolean estaVivo() {
        return false;
    }

    public void subirNivel() {

    }

}
