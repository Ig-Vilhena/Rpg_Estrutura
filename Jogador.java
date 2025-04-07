package Jogadores;

import java.rmi.server.UID;
import java.util.UUID;

public class Jogador {

    private String id;
    private String nome;
    private String senha;
    private double saldoMoedas;

    private Fila personagens;

    public Jogador() {
    }

    public Jogador(String nome, String senha) {

        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.senha = senha;
        this.saldoMoedas = 0;
        this.personagens = new Fila(5);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void cadastrar() {

    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public void criarPersonagem() {

    }

    public void selecionarPersonagem() {

    }

}
