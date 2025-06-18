package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;

public class UsuarioDAO {
    private static UsuarioDAO instance = null;

    private PreparedStatement insert;
    private PreparedStatement delete;

    private UsuarioDAO() throws SQLException, ClassNotFoundException{
        Connection conexao = Conexao.getConexao();
        insert = conexao.prepareStatement("INSERT INTO usuario (nome, senha, descricao, email) VALUES (?, ?, ?, ?)");
        delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
    }

    public static UsuarioDAO getInstance() throws ClassNotFoundException, SQLException {
        if(instance == null){
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public void insert(Usuario usuario) throws InsertException, SQLException, ClassNotFoundException {
        try{
            if (insert == null) {
                new UsuarioDAO();
            }
            insert.setString(1, usuario.getNome());
            insert.setString(2, usuario.getSenha());
            if(usuario.getDescricao().isEmpty()){
                insert.setNull(3, java.sql.Types.VARCHAR);
            } else {
                insert.setString(3, usuario.getDescricao());
            }
            insert.setString(4, usuario.getEmail());
            insert.executeUpdate();
        }catch(SQLException e){
            throw new InsertException("Erro ao fazer login do usuario");
        }
    }

    public void delete(int id) throws DeleteException, SQLException, ClassNotFoundException {
        try {
            if (delete == null) {
                new UsuarioDAO();
            }
            delete.setInt(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar o usuario");
        }
    }


}
