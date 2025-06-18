package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Usuario;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;

public class UsuarioDAO {
    private static UsuarioDAO instance = null;

    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement show;

    private UsuarioDAO() throws SQLException, ClassNotFoundException{
        Connection conexao = Conexao.getConexao();
        insert = conexao.prepareStatement("INSERT INTO usuario (nome, senha, descricao, email) VALUES (?, ?, ?, ?)");
        delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
        show = conexao.prepareStatement("SELECT * FROM usuario");
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

    public List<Usuario> show() throws SQLException, ClassNotFoundException, SelectException {
        try{
            List<Usuario> usuarios = new LinkedList<Usuario>();

            if (show == null) {
                new UsuarioDAO();
            }
            ResultSet rs = show.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                if(rs.getString("descricao") != null){
                    usuario.setDescricao(rs.getString("descricao"));
                } else {
                    usuario.setDescricao("[null]");
                }
                usuarios.add(usuario);
            }
            return usuarios;
        }catch(SQLException e){
            throw new SelectException("Erro ao buscar usuarios");
        }
    }

    
}
