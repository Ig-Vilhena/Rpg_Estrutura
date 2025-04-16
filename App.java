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
            System.out.println("==== Bem vindo ao RPG X ====");
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
                
                    do{
                        System.out.println("\n===== PERSONAGENS CRIADOS =====");
                        jogador.getPersonagens().exibir();


                        if (!jogador.getPersonagens().isEmpty()) {
                            System.out.println("\nDeseja editar algum personagem?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            opcao = sc.nextLine();

                            switch (opcao) {
                                case "1":
                                    boolean personagemValido = false;
                                    while (!personagemValido) {
                                        System.out.println("Digite o índice do personagem que deseja editar:");
                                        int indice = sc.nextInt();
                                        sc.nextLine();

                                        Personagens personagem = jogador.getPersonagens().getElementoPorIndice(indice);
                                        if (personagem != null) {
                                            System.out.println("Personagem selecionado: " + personagem.getNome());

                                            System.out.println("Digite o novo nome:");
                                            String novoNome = sc.nextLine();
                                            personagem.setNome(novoNome);
                                            System.out.println("Nome atualizado com sucesso!");
                                            personagemValido = true;
                                            continuar = false;
                                        } else {
                                            System.out.println("Índice inválido. Personagem inexistente. Tente novamente.");
                                        }
                                    }
                                    break;


                                case "2":
                                System.out.println("Saindo...");
                                continuar = false;
                                break;

                                default:
                                System.out.println("Opção inválida.");
                                break;
                            }
                        }else{
                            continuar = false;
                        }   
                    }while (continuar);

                    continuar = true;
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
                    if (!jogador.getPersonagens().isEmpty()){
                        System.out.println("==== Tipo de batalha ====");
                        System.out.println("1. PvP");
                        System.out.println("2. PvE");
                        opcao = sc.nextLine();

                        switch (opcao) {
                            case "1":
                                do {
                                System.out.println("\n===== PERSONAGENS CRIADOS =====");
                                jogador.getPersonagens().exibir();

                                if (!jogador.getPersonagens().isEmpty()) {
                                    Personagens personagem1 = null;
                                    Personagens personagem2 = null;
                            
                                    while (personagem1 == null) {
                                        System.out.println("\nJogador 1, escolha o personagem:");
                                        int indice1 = sc.nextInt();
                                        sc.nextLine(); 
                                        personagem1 = jogador.getPersonagens().getElementoPorIndice(indice1);
                            
                                        if (personagem1 == null) {
                                            System.out.println("Personagem inválido. Tente novamente.");
                                        } else {
                                            System.out.println("Jogador 1 selecionou: " + personagem1.getNome());
                                        }
                                    }
                                    
                                    while (personagem2 == null) {
                                        System.out.println("\nJogador 2, escolha o personagem:");
                                        int indice2 = sc.nextInt();
                                        sc.nextLine(); 
                                        personagem2 = jogador.getPersonagens().getElementoPorIndice(indice2);
                            
                                        if (personagem2 == null) {
                                            System.out.println("Personagem inválido. Tente novamente.");
                                        } else {
                                            System.out.println("Jogador 2 selecionou: " + personagem2.getNome());
                                        }
                                    }
                                    
                                    Fila fila = new Fila(2);
                                    fila.enfileirar(personagem1);
                                    fila.enfileirar(personagem2);

                                    Arena batalhaPvE = new Arena(1, fila);
                                    batalhaPvE.iniciarBatalha();   
                                    
                                    do {
                                        System.out.println("Deseja jogar novamente?");
                                        System.out.println("1. Sim");
                                        System.out.println("2. Não");
                                        opcao = sc.nextLine();
                                    
                                        if (opcao.equals("1")) {
                                            personagem1.setVidaAtual(personagem1.getVidaMaxima());
                                            personagem2.setVidaAtual(personagem2.getVidaMaxima());
                                            continuar = true;
                                        } else if (opcao.equals("2")) {
                                            if (personagem1 != null && personagem2 != null) {
                                                personagem1.setVidaAtual(personagem1.getVidaMaxima());
                                                personagem1.setVidaAtual(personagem2.getVidaMaxima());
                                            }
                                            continuar = false;
                                        } else {
                                            System.out.println("Opção inválida.");
                                        }
                                    } while (!opcao.equals("1") && !opcao.equals("2"));
                                }
                            } while (continuar);
    
                            continuar = true;
                            break;

                            case "2":
                            do {
                                System.out.println("\n===== PERSONAGENS CRIADOS =====");
                                jogador.getPersonagens().exibir();

                                if (!jogador.getPersonagens().isEmpty()) {
                                    System.out.println("\nEscolha o personagem: ");
                                    int indice = sc.nextInt();
                                    sc.nextLine();

                                    Personagens personagem = jogador.getPersonagens().getElementoPorIndice(indice);
                                    if (personagem != null) {
                                            System.out.println("Personagem selecionado: " + personagem.getNome());

                                        Fila fila = new Fila(2);
                                        fila.enfileirar(personagem);

                                
                                        Inimigo inimigo = new Inimigo("Goblin", 1, 80, 80, 30, 30, "Goblin");
                                        fila.enfileirar(inimigo);

                                        Arena batalhaPvE = new Arena(1, fila);
                                        batalhaPvE.iniciarBatalha();
                                    }
                                    do{
                                        System.out.println("Deseja jogar novamente");
                                        System.out.println("1. Sim");
                                        System.out.println("2. Não");
                                        opcao = sc.nextLine();

                                        if (opcao == "1") {
                                            
                                        }else if (opcao == "2") {
                                            continuar = false;
                                        }else{
                                            System.out.println("Opção inválida. Tente novamente.");
                                        }
                                    }while(continuar);
                                }
                            } while (continuar);
                            continuar = true;
                            break;
                        
                            default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                        } 

                    }else{
                        System.out.println("Você precisa criar pelo menos um personagem antes de iniciar uma batalha.");
                    }
                    
                    break;

                case "X":
                case "x":
                    System.out.println("Encerrando o jogo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        sc.close();
    }
}
