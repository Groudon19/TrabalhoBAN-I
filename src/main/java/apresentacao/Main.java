package apresentacao;

import java.sql.SQLException;
import java.util.Scanner;

import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;
import negocio.FuncaoUsuario;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    private static FuncaoUsuario funcaoUsuario;

    public static void main(String[] args) {
        
        try{
            funcaoUsuario = new FuncaoUsuario("Groudon19!");

            System.out.println("Escolha a oopcao:");
            int opcao = -1;
            do {
                opcao = menu(scan);
                switch (opcao) {
                    case 1:
                        int opcaoUser = menuUsuario(scan);
                        switch (opcaoUser) {
                            case 1:
                                // Chamar método para cadastrar usuário
                                System.out.println("Cadastrar Usuário");
                                cadastraUsuario(funcaoUsuario);
                                break;
                            case 2:
                                // Chamar método para mostrar usuários
                                System.out.println("Mostrar Usuários");
                                break;
                            case 3:
                                // Chamar método para buscar usuário
                                System.out.println("Buscar Usuário");
                                break;
                            case 4:
                                // Chamar método para excluir usuário
                                System.out.println("Excluir Usuário");
                                deleteUsuario();
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                        break;
                    case 2:
                        int opcaoPost = menuPost(scan);
                        switch(opcaoPost){
                            case 1:
                                // Chamar método para cadastrar post
                                System.out.println("Cadastrar Post");
                                break;
                            case 2:
                                // Chamar método para mostrar posts
                                System.out.println("Mostrar Posts");
                                break;
                            case 3:
                                // Chamar método para buscar post
                                System.out.println("Buscar Post");
                                break;
                            case 4:
                                // Chamar método para excluir post
                                System.out.println("Excluir Post");
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                        
                        break;
                    case 3:
                        int opcaoMidia = menuMidia(scan);
                        switch(opcaoMidia){
                            case 1:
                                // Chamar método para cadastrar mídia
                                System.out.println("Cadastrar Mídia");
                                break;
                            case 2:
                                // Chamar método para mostrar mídias
                                System.out.println("Mostrar Mídias");
                                break;
                            case 3:
                                // Chamar método para buscar mídia
                                System.out.println("Buscar Mídia");
                                break;
                            case 4:
                                // Chamar método para excluir mídia
                                System.out.println("Excluir Mídia");
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                        break;
                    case 4:
                        int opcaoMensagem = menuMensagem(scan);
                        switch(opcaoMensagem){
                            case 1:
                                // Chamar método para cadastrar mensagem
                                System.out.println("Cadastrar Mensagem");
                                break;
                            case 2:
                                // Chamar método para mostrar mensagens
                                System.out.println("Mostrar Mensagens");
                                break;
                            case 3:
                                // Chamar método para buscar mensagem
                                System.out.println("Buscar Mensagem");
                                break;
                            case 4:
                                // Chamar método para excluir mensagem
                                System.out.println("Excluir Mensagem");
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    
                        break;
                    case 5:
                        int opcaoConversa = menuConversa(scan);
                        switch(opcaoConversa){
                            case 1:
                                // Chamar método para cadastrar conversa
                                System.out.println("Cadastrar Conversa");
                                break;
                            case 2:
                                // Chamar método para mostrar conversas
                                System.out.println("Mostrar Conversas");
                                break;
                            case 3:
                                // Chamar método para buscar conversa
                                System.out.println("Buscar Conversa");
                                break;
                            case 4:
                                // Chamar método para excluir conversa
                                System.out.println("Excluir Conversa");
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                        
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
            System.out.println("Programa encerrado.");
        }catch(SQLException | ClassNotFoundException | InsertException | DeleteException e){
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());

        }

    }

    public static int menu(Scanner scan){
        System.out.println("1 - Usuario");
        System.out.println("2 - Post");
        System.out.println("3 - Midia");
        System.out.println("4 - Mensagem");
        System.out.println("5 - Conversa");
        System.out.println("0 - Sair do Programa");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuUsuario(Scanner scan){
        System.out.println("1 - Cadastrar Usuario");
        System.out.println("2 - Mostrar Usuarios");
        System.out.println("3 - Buscar Usuario");
        System.out.println("4 - Excluir Usuario");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuPost(Scanner scan){
        System.out.println("1 - Cadastrar Post");
        System.out.println("2 - Mostrar Posts");
        System.out.println("3 - Buscar Post");
        System.out.println("4 - Excluir Post");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuMidia(Scanner scan){
        System.out.println("1 - Cadastrar Midia");
        System.out.println("2 - Mostrar Midias");
        System.out.println("3 - Buscar Midia");
        System.out.println("4 - Excluir Midia"); //estranho
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuMensagem(Scanner scan){
        System.out.println("1 - Cadastrar Mensagem");
        System.out.println("2 - Mostrar Mensagens");
        System.out.println("3 - Buscar Mensagem");
        System.out.println("4 - Excluir Mensagem");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }   

    public static int menuConversa(Scanner scan){
        System.out.println("1 - Cadastrar Conversa");
        System.out.println("2 - Mostrar Conversas");
        System.out.println("3 - Buscar Conversa");
        System.out.println("4 - Excluir Conversa");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static void cadastraUsuario(FuncaoUsuario funcaoUsuario) throws SQLException, ClassNotFoundException, InsertException {
        Usuario usuario = new Usuario();
        System.out.println("Digite o nome do usuário:");
        String nome = scan.nextLine();
        System.out.println("Digite o email do usuário:");
        String email = scan.nextLine(); 
        System.out.println("Digite a senha do usuário:");
        String senha = scan.nextLine();
        System.out.println("Digite a descrição do usuário (opcional):");
        String descricao = scan.nextLine();

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha); 
        usuario.setDescricao(descricao);

        funcaoUsuario.insereUsuario(usuario);
    }

    public static void deleteUsuario() throws SQLException, ClassNotFoundException, DeleteException {
        System.out.println("Digite o ID do usuário a ser excluído:");
        int id = Integer.parseInt(scan.nextLine());
        
        funcaoUsuario.removeUsuario(id);
    }
}
