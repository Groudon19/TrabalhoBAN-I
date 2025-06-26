package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dados.Conversa;
import dados.Mensagem;
import excecoes.DeleteException;
import excecoes.InsertException;
import excecoes.SelectException;

public class ConversaDAO {
    private static ConversaDAO instancia;  
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement show;
    private PreparedStatement participa;
    private PreparedStatement showConversa;


    private ConversaDAO() throws ClassNotFoundException, SQLException {
        // Construtor privado para evitar instanciamento externo
        Connection conexao = Conexao.getConexao();
        insert = conexao.prepareStatement("INSERT INTO conversa (nome_conversa) VALUES (?)");
        delete = conexao.prepareStatement("DELETE FROM conversa WHERE id_conversa = ?");
        show = conexao.prepareStatement("SELECT * FROM conversa");
        showConversa = conexao.prepareStatement("SELECT m.* FROM recebe r, mensagem m WHERE ? = r.id_conversa AND m.id_mensagem = r.id_mensagem ORDER BY m.data_hora;");
        participa = conexao.prepareStatement("INSERT INTO participa (id_conversa, id_usuario) VALUES (?, ?)");
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

    public List<Mensagem> showConversa(int id_conversa) throws SQLException, ClassNotFoundException, SelectException {
        try{
            if(showConversa == null){
                new ConversaDAO();
            }

            showConversa.setInt(1, id_conversa);
            ResultSet rs = showConversa.executeQuery();

            List<Mensagem> mensagens = new LinkedList<Mensagem>();

            while(rs.next()){
                Mensagem mensagem = new Mensagem();
                mensagem.setId_mensagem(rs.getInt("id_mensagem"));
                mensagem.setData_hora(rs.getTimestamp("data_hora"));

                if(rs.getString("texto") != null) {
                    mensagem.setTexto(rs.getString("texto"));
                } else {
                    mensagem.setTexto("[null]");
                }

                mensagem.setId_usuario(rs.getInt("id_usuario"));

                if(rs.wasNull()) {
                    mensagem.setId_post(0);
                } else {
                    mensagem.setId_post(rs.getInt("id_post"));
                }

                if(rs.wasNull()) {
                    mensagem.setId_midia(0);
                } else {
                    mensagem.setId_midia(rs.getInt("id_midia"));
                }

                mensagem.setEntregue(rs.getBoolean("entregue"));
                mensagem.setVisualizado(rs.getBoolean("visualizado"));
                mensagens.add(mensagem);
            }
            return mensagens;
        }catch(SQLException e){
            throw new SelectException("Erro ao mostrar a conversa");
        }
    }

    public void participa(int id_conversa, int id_usuario) throws SQLException, ClassNotFoundException, InsertException {
        try {
            if(participa == null){
                new ConversaDAO();
            }
            participa.setInt(1, id_conversa);
            participa.setInt(2, id_usuario);

            participa.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao participar na conversa");
        }
    }
}
