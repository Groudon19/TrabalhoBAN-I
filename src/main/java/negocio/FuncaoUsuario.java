package negocio;

import java.sql.SQLException;

import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;
import persistencia.Conexao;
import persistencia.UsuarioDAO;

public class FuncaoUsuario {
    private UsuarioDAO usuarioDAO;

    public FuncaoUsuario(String senha) throws ClassNotFoundException, SQLException {
        Conexao.setSenha(senha);
        usuarioDAO = UsuarioDAO.getInstance();
    }

    public void insereUsuario(Usuario usuario) throws InsertException, SQLException, ClassNotFoundException {
        usuarioDAO.insert(usuario);
    }

    public void removeUsuario(int id) throws SQLException, ClassNotFoundException, DeleteException {
        usuarioDAO.delete(id);
    }

    
}
