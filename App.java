import java.util.Scanner;

import Jogadores.Jogador;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Jogador j2 = new Jogador();
        String opcao;

        do {
            System.out.println("/=== Bem vindo ao XXXXXX ===/");
            System.out.println("1. Criar conta nova");
            System.out.println("2. Login");
            System.out.println("X. Fechar");

            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Qual seu nome? ");
                    String nome = sc.nextLine();
                    System.out.println("Qual sua senha?: ");
                    String senha = sc.nextLine();
                    j2 = new Jogador(nome, senha);

                    System.out.println("Conta criada com sucesso!");
                    System.out.println("nome e senha" + j2.getNome() + j2.getSenha());
                    break;

                case "2":
                    boolean loginSucesso = false;
                    do {

                        System.out.println("Insira nome de Login: ");
                        String nome2 = sc.nextLine();
                        System.out.println("Insira senha: ");
                        String senha1 = sc.nextLine();

                        if (j2.autenticar(nome2, senha1)) {
                            System.out.println("Login realizado com sucesso!");
                            loginSucesso = true;
                        } else {
                            System.out.println("Nome de usuário ou senha incorretos.");
                        }
                    } while (!loginSucesso);

                    break;
             case "3":
                  if (jogador.selecionarPersonagem(0) == null) {
                   System.out.println("Você precisa criar pelo menos um personagem.");
                    } else {
                   System.out.print("Nome do inimigo: ");
                String nomeInimigo = sc.nextLine();

        
               Personagem inimigo = new Personagem(nomeInimigo, 1, 80, 40);
               Arena arena = new Arena(jogador.selecionarPersonagem(0), inimigo);
               arena.iniciarBatalha();
            }
                   break;        

                case "X":
                case "x":
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (!opcao.equalsIgnoreCase("X") || ); 
        sc.close();
    }
}
