package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Conversa;
import excecoes.DeleteException;
import excecoes.InsertException;
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

    public void inserirConversa(String nomeConversa) throws SQLException, ClassNotFoundException, InsertException {
        try {
            if (insert == null) {
                new ConversaDAO();
            }
            insert.setString(1, nomeConversa);
            insert.executeUpdate();

        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir conversa: " + e.getMessage());
        }
    }

    public void deleteConversa(int idConversa) throws SQLException, ClassNotFoundException, DeleteException {
        try {
            if (delete == null) {
                new ConversaDAO();
            }
            delete.setInt(1, idConversa);
            delete.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar conversa: " + e.getMessage());
        }
    }

    public List<Conversa> show() throws SQLException, ClassNotFoundException, SelectException {
        List<Conversa> conversas = new ArrayList<>();
        try {
            if (show == null) {
                new ConversaDAO();
            }
            ResultSet rs = show.executeQuery();
            while (rs.next()) {
                Conversa conversa = new Conversa();
                int id = rs.getInt("id_conversa");
                String nome = rs.getString("nome_conversa");
                conversa.setId_conversa(id);
                conversa.setNome_conversa(nome);
                conversas.add(conversa);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao mostrar conversas: " + e.getMessage());
        }
        return conversas;
    }
}
