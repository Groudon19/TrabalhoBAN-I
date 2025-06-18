package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;
import persistencia.Conexao;
import persistencia.UsuarioDAO;

public class Sistema {
    private UsuarioDAO usuarioDAO;

    public Sistema(String senha) throws ClassNotFoundException, SQLException {
        Conexao.setSenha(senha);
        usuarioDAO = UsuarioDAO.getInstance();
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
    
}
