import java.util.UUID;
import java.util.Scanner;

public class Jogador {

    private String id;
    private String nome;
    private String senha;
    private double saldoMoedas;
    private Fila personagens;

    public Fila getPersonagens() {
        return personagens;
    }

    public Jogador() {
        this.personagens = new Fila(5);
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

    public String getId() {
        return id;
    }

    public double getSaldoMoedas() {
        return saldoMoedas;
    }

    public void adicionarSaldo(double valor) {
        this.saldoMoedas += valor;
    }

    public void cadastrar(String nome, String senha) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.senha = senha;
        this.saldoMoedas = 0;
        this.personagens = new Fila(5);
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public void criarPersonagem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do personagem: ");
        String nomePersonagem = sc.nextLine();

        Personagens novoPersonagem = new Personagens(nomePersonagem, 1, 100, 100, 50, 50);
        boolean inseriu = personagens.enfileirar(novoPersonagem);

        if (inseriu) {
            System.out.println("Personagem criado com sucesso!");
        } else {
            System.out.println("Fila de personagens cheia.");
        }
    }

    public Personagens selecionarPersonagem() {
        if (personagens.isEmpty()) {
            System.out.println("Nenhum personagem disponível.");
            return null;
        }
        return (Personagens) personagens.espiar();
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + " | ID: " + id + " | Saldo: " + saldoMoedas + " moedas";
    }
}import java.util.UUID;
import java.util.Scanner;

public class Jogador {

    private String id;
    private String nome;
    private String senha;
    private double saldoMoedas;
    private Fila personagens;

    public Fila getPersonagens() {
        return personagens;
    }

    public Jogador() {
        this.personagens = new Fila(5);
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

    public String getId() {
        return id;
    }

    public double getSaldoMoedas() {
        return saldoMoedas;
    }

    public void adicionarSaldo(double valor) {
        this.saldoMoedas += valor;
    }

    public void cadastrar(String nome, String senha) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.senha = senha;
        this.saldoMoedas = 0;
        this.personagens = new Fila(5);
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public void criarPersonagem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do personagem: ");
        String nomePersonagem = sc.nextLine();

        Personagens novoPersonagem = new Personagens(nomePersonagem, 1, 100, 100, 50, 50);
        boolean inseriu = personagens.enfileirar(novoPersonagem);

        if (inseriu) {
            System.out.println("Personagem criado com sucesso!");
        } else {
            System.out.println("Fila de personagens cheia.");
        }
    }

    public Personagens selecionarPersonagem() {
        if (personagens.isEmpty()) {
            System.out.println("Nenhum personagem disponível.");
            return null;
        }
        return (Personagens) personagens.espiar();
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + " | ID: " + id + " | Saldo: " + saldoMoedas + " moedas";
    }
}
