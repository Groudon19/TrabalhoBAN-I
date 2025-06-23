package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import excecoes.SelectException;

public class ConversaDAO {
    private static ConversaDAO instancia;  
    PreparedStatement insert;
    PreparedStatement delete;
    PreparedStatement show; 

    private ConversaDAO() throws ClassNotFoundException, SQLException {
        // Construtor privado para evitar instanciamento externo
        Connection conexao = Conexao.getConexao();
        insert = conexao.prepareStatement("INSERT INTO conversa (nome_conversa) VALUES (?)");
        delete = conexao.prepareStatement("DELETE FROM conversa WHERE id_conversa = ?");
        show = conexao.prepareStatement("SELECT * FROM conversa");
        
    }

    public static ConversaDAO getInstance() throws ClassNotFoundException, SQLException {
        if (instancia == null) {
            instancia = new ConversaDAO();
        }
        return instancia;
    }

    public void inserirConversa(String nomeConversa) throws SQLException, ClassNotFoundException, SelectException {
        try {
            if (insert == null) {
                new ConversaDAO();
            }
            insert.setString(1, nomeConversa);
            insert.executeUpdate();

        } catch (SQLException e) {
            throw new SelectException("Erro ao inserir conversa ");
        }
    }


}
