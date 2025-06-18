package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dados.Post;
import excecoes.InsertException;

public class PostDAO {
    private static PostDAO instance = null;

    private PreparedStatement insert;

    private PostDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();
        insert = conexao.prepareStatement("INSERT INTO post (id_usuario, data_hora, legenda) VALUES (?, ?, ?)");
    }

    public static PostDAO getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new PostDAO();
        }
        return instance;
    }

    public void insert(Post post) throws SQLException, ClassNotFoundException, InsertException {
        try{
            if (insert == null) {
                new PostDAO();
            }
            insert.setInt(1, post.getId_usuario());
            insert.setTimestamp(2, post.getData_hora());
            if (post.getLegenda() == null || post.getLegenda().isEmpty()) {
                insert.setNull(3, java.sql.Types.VARCHAR);
            } else {
                insert.setString(3, post.getLegenda());
            }
            insert.executeUpdate();
        }catch (SQLException e) {
            throw new InsertException("Erro ao publicar o post");
        }
    }
}
