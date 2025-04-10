import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador jogador = null;
        String opcao;
        boolean continuar = true;
        Arena arena = new Arena();

        // Tela Login/Cadastro
        do {
            System.out.println("/=== Bem vindo ao RPG X ===/");
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
                    jogador = new Jogador(nome, senha);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case "2":
                    if (jogador == null) {
                        System.out.println("Nenhuma conta criada. Crie uma conta primeiro.");
                        break;
                    }
                    boolean loginSucesso = false;
                    do {
                        System.out.println("Insira nome de Login: ");
                        String nome1 = sc.nextLine();
                        System.out.println("Insira senha: ");
                        String senha1 = sc.nextLine();

                        if (jogador.autenticar(nome1, senha1)) {
                            System.out.println("Login realizado com sucesso!");
                            loginSucesso = true;
                            continuar = false;
                        } else {
                            System.out.println("Nome de usuário ou senha incorretos ou inexistentes.");
                        }
                    } while (!loginSucesso);
                    break;

                case "X":
                case "x":
                    System.out.println("Encerrando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (continuar);

        // Menu Principal
        continuar = true;
        while (continuar) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Ver/Editar Personagens");
            System.out.println("2. Criar Novo Personagem");
            System.out.println("3. Atribuir Pontos de Atributos");
            System.out.println("4. Comprar/Equipar Itens");
            System.out.println("5. Iniciar Batalha");
            System.out.println("X. Sair");
            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\n===== PERSONAGENS CRIADOS =====");
                    jogador.getPersonagens().exibir();
                    break;

                case "2":
                    jogador.criarPersonagem();
                    break;

                case "3":
                    // jogador.atribuirAtributos(sc);
                    break;

                case "4":
                    // jogador.comprarEquiparItens(sc);
                    break;

                case "5":
                    System.out.println("Tipo de batalha");
                    System.out.println("1. PvP");
                    System.out.println("2. PvE");
                    opcao = sc.nextLine();

                    if (opcao == "1") {
                        
                    }else if (opcao == "2") {
                        

                    }else{
                        System.out.println("opcao inexistente");
                    }
                    break;

                case "X":
                case "x":
                    System.out.println("Encerrando o jogo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}
