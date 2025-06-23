package apresentacao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import dados.Mensagem;
import dados.Midia;
import dados.Post;
import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import negocio.Sistema;

// TODO: Mensagem de erro para usuário não encontrado ao excluir
// TODO: Mensagem de erro para usuário já cadastrado ao cadastrar
// TODO: Uma opção para listar o resultado de uma consulta que envolva uma junção entre duas tabelas: Mensagens na conversa
// TODO: Uma opção para listar o resultado de uma consulta que envolva subconsulta(s) e uma ou mais funções de agregação: Usuario com mais seguidores

public class Main {
    private static Scanner scan = new Scanner(System.in);

    private static Sistema sistema;

    public static void main(String[] args) {
        
        try{
            sistema = new Sistema("Groudon19!");

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
                                cadastraUsuario(sistema);
                                break;
                            case 2:
                                // Chamar método para mostrar usuários
                                System.out.println("Mostrar Usuários");
                                mostraUsuarios();
                                break;
                            case 3:
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
                                System.out.println("Publicar Post");
                                publicaPost(sistema);
                                break;
                            case 2:
                                // Chamar método para mostrar posts
                                System.out.println("Mostrar Posts");
                                mostraPosts();
                                break;
                            case 3:
                                // Chamar método para excluir post
                                System.out.println("Excluir Post");
                                deletePost();
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
                                System.out.println("Publica Mídia");
                                publicaMidia(sistema);
                                break;
                            case 2:
                                // Chamar método para mostrar mídias
                                System.out.println("Mostrar Mídias");
                                mostraMidias();
                                break;
                            case 3:
                                // Chamar método para excluir mídia
                                System.out.println("Excluir Mídia");
                                deleteMidia();
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
                                System.out.println("Mandar Mensagem");
                                mandaMensagem();
                                break;
                            case 2:
                                // Chamar método para mostrar mensagens
                                System.out.println("Mostrar Mensagens");
                                break;
                            case 3:
                                // Chamar método para excluir mensagem
                                System.out.println("Excluir Mensagem");
                                removeMensagem();
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
        }catch(SQLException | ClassNotFoundException | InsertException | DeleteException | SelectException e){
            e.printStackTrace();

        }

    }

    public static int menu(Scanner scan){
        System.out.println("-------- Menu Principal --------");
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
        System.out.println("-------- Usuario --------");
        System.out.println("1 - Cadastrar Usuario");
        System.out.println("2 - Mostrar Usuarios");
        System.out.println("3 - Excluir Usuario");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuPost(Scanner scan){
        System.out.println("-------- Post --------");
        System.out.println("1 - Publicar Post");
        System.out.println("2 - Mostrar Posts");
        System.out.println("3 - Excluir Post");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuMidia(Scanner scan){
        System.out.println("-------- Midia --------");
        System.out.println("1 - Publica Midia");
        System.out.println("2 - Mostrar Midias");
        System.out.println("3 - Excluir Midia"); //estranho
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static int menuMensagem(Scanner scan){
        System.out.println("-------- Mensagem --------");
        System.out.println("1 - Cadastrar Mensagem");
        System.out.println("2 - Mostrar Mensagens");
        System.out.println("3 - Excluir Mensagem");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }   

    public static int menuConversa(Scanner scan){
        System.out.println("-------- Conversa --------");
        System.out.println("1 - Cadastrar Conversa");
        System.out.println("2 - Mostrar Conversas");
        System.out.println("3 - Excluir Conversa");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Sua opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public static void cadastraUsuario(Sistema sistema) throws SQLException, ClassNotFoundException, InsertException {
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

        sistema.insereUsuario(usuario);
    }

    public static void mostraUsuarios() throws SQLException, ClassNotFoundException, SelectException{
        System.out.println("Id - Nome - Descrição");
        for (Usuario usuario : sistema.mostraUsuarios()) {
            System.out.println(usuario);
        }
    }

    public static void deleteUsuario() throws SQLException, ClassNotFoundException, DeleteException, SelectException {
        mostraUsuarios();
        System.out.println("Digite o ID do usuário a ser excluído:");
        int id = Integer.parseInt(scan.nextLine());
        
        sistema.removeUsuario(id);
    }

    public static void publicaPost(Sistema sistema) throws SQLException, ClassNotFoundException, InsertException, SelectException {
        Post post = new Post();
        mostraUsuarios();
        System.out.println("Digite o ID do usuário que está publicando:");
        int id_usuario = Integer.parseInt(scan.nextLine());
        System.out.println("Digite a legenda do post (opcional):");
        String legenda = scan.nextLine();

        post.setId_usuario(id_usuario);
        post.setData_hora(new Timestamp(System.currentTimeMillis()));
        post.setLegenda(legenda);

        sistema.inserePost(post);
    }

    public static void deletePost() throws SQLException, ClassNotFoundException, DeleteException, SelectException {
        mostraPosts();
        System.out.println("Digite o ID do post a ser excluído:");
        int id = Integer.parseInt(scan.nextLine());
        sistema.removePost(id);
    }

    public static void mostraPosts() throws SQLException, ClassNotFoundException, SelectException {
        System.out.println("Id - Usuario - Data/Hora - Legenda");
        for (Post post : sistema.mostraPosts()) {
            System.out.println(post);
        }
    }

    public static void publicaMidia(Sistema sistema) throws SQLException, ClassNotFoundException, InsertException, SelectException {
        Midia midia = new Midia();
        System.out.println("Digite o tamanho da mídia:");
        int tamanho = Integer.parseInt(scan.nextLine());
        System.out.println("Digite o tipo da mídia (1 para imagem, 2 para vídeo):");
        int tipo = Integer.parseInt(scan.nextLine());
        int duracao = 0;
        if(tipo == 2) {
            System.out.println("Digite a duração da mídia (em segundos, opcional):");
            String duracaoInput = scan.nextLine();
            if (!duracaoInput.isEmpty()) {
                duracao = Integer.parseInt(duracaoInput);
            }
        }
        midia.setTamanho(tamanho);
        midia.setTipo(tipo);
        midia.setDuracao(duracao);

        sistema.insereMidia(midia);
    }

    public static void deleteMidia() throws SQLException, ClassNotFoundException, DeleteException, SelectException {
        mostraMidias();
        System.out.println("Digite o ID da mídia a ser excluída:");
        int id = Integer.parseInt(scan.nextLine());
        sistema.removeMidia(id);
    }

    public static void mostraMidias() throws SQLException, ClassNotFoundException, SelectException {
        System.out.println("Id - Tamanho - Tipo - (Duração)");
        for (Midia midia : sistema.mostraMidias()) {
            System.out.println(midia);
        }
    }

    public static void mandaMensagem() throws SQLException, ClassNotFoundException, InsertException, SelectException {
        Mensagem mensagem = new Mensagem();
        System.out.println("Digite o ID do usuário que está enviando a mensagem:");
        int id_usuario = Integer.parseInt(scan.nextLine());

        int id_post = 0;
        int id_midia = 0;
        System.out.println("Digite o ID do post relacionado (opcional):");
        String id_post_input = scan.nextLine();
        if (!id_post_input.isEmpty()) {
            id_post = Integer.parseInt(id_post_input);
        }

        if(id_post == 0){
            System.out.println("Digite o ID da mídia relacionada (opcional):");
            String id_midia_input = scan.nextLine();
            if (!id_midia_input.isEmpty()) {
                id_midia = Integer.parseInt(id_midia_input);
            }
        }

        String texto = "";
        do{
            System.out.println("Digite o texto da mensagem:");
            texto = scan.nextLine();
        }while((id_post == 0 || id_midia == 0) && texto.isEmpty());

        Timestamp data_hora = new Timestamp(System.currentTimeMillis());

        mensagem.setId_usuario(id_usuario);
        mensagem.setId_post(id_post);
        mensagem.setId_midia(id_midia);
        mensagem.setTexto(texto);
        mensagem.setData_hora(data_hora);
        mensagem.setEntregue(true);
        mensagem.setVisualizado(false);

        sistema.insereMensagem(mensagem);
    }

    public static void removeMensagem() throws SQLException, ClassNotFoundException, DeleteException {
        System.out.println("Digite o ID da mensagem a ser excluída:");
        int id_mensagem = Integer.parseInt(scan.nextLine());
        sistema.removeMensagem(id_mensagem);
    }

    
}
