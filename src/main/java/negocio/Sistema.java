package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.Mensagem;
import dados.Midia;
import dados.Post;
import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import persistencia.Conexao;
import persistencia.MensagemDAO;
import persistencia.MidiaDAO;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

public class Sistema {
    private UsuarioDAO usuarioDAO;
    private PostDAO postDAO;
    private MidiaDAO midiaDAO;
    private MensagemDAO mensagemDAO;


    public Sistema(String senha) throws ClassNotFoundException, SQLException {
        Conexao.setSenha(senha);
        usuarioDAO = UsuarioDAO.getInstance();
        postDAO = PostDAO.getInstance();
        midiaDAO = MidiaDAO.getInstance();
        mensagemDAO = MensagemDAO.getInstance();
    }

    public void insereUsuario(Usuario usuario) throws InsertException, SQLException, ClassNotFoundException {
        usuarioDAO.insert(usuario);
    }

    public void removeUsuario(int id) throws SQLException, ClassNotFoundException, DeleteException {
        usuarioDAO.delete(id);
    }

    public List<Usuario> mostraUsuarios() throws SQLException, ClassNotFoundException, SelectException {
        return usuarioDAO.show();
    }

    public void inserePost(Post post) throws SQLException, ClassNotFoundException, InsertException {
        postDAO.insert(post);
    }

    public void removePost(int id) throws SQLException, ClassNotFoundException, DeleteException {
        postDAO.delete(id);
    }

    public List<Post> mostraPosts() throws SQLException, ClassNotFoundException, SelectException {
        return postDAO.show();
    }

    public void insereMidia(Midia midia) throws SQLException, ClassNotFoundException, InsertException {
        midiaDAO.insert(midia);
    }

    public void removeMidia(int id) throws SQLException, ClassNotFoundException, DeleteException {
        midiaDAO.delete(id);
    }

    public List<Midia> mostraMidias() throws SQLException, ClassNotFoundException, SelectException {
        return midiaDAO.show();
    }

    public void insereMensagem(Mensagem mensagem) throws SQLException, ClassNotFoundException, InsertException {
        mensagemDAO.insert(mensagem);
    }
    
}
