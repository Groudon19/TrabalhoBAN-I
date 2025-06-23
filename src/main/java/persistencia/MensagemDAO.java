package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dados.Mensagem;
import excecoes.DeleteException;

public class MensagemDAO {
    private static MensagemDAO instance = null;

    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement show;

    private MensagemDAO() throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();
        insert = conexao.prepareStatement("INSERT INTO mensagem (data_hora, texto, id_usuario, id_post, id_midia, entregue, visualizado) VALUES (?, ?, ?, ?, ?, ?, ?)");
        delete = conexao.prepareStatement("DELETE FROM mensagem WHERE id_mensagem = ?");
        show = conexao.prepareStatement("SELECT * FROM mensagem");
    }

    public static MensagemDAO getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new MensagemDAO();
        }
        return instance;
    }

    public void insert(Mensagem mensagem) throws SQLException, ClassNotFoundException {
        if (insert == null) {
            new MensagemDAO();
        }
        insert.setTimestamp(1, mensagem.getData_hora());
        if (mensagem.getTexto() == null || mensagem.getTexto().isEmpty()) {
            insert.setNull(2, java.sql.Types.VARCHAR);
        } else {
            insert.setString(2, mensagem.getTexto());
        }

        insert.setInt(3, mensagem.getId_usuario());

        if (mensagem.getId_post() == 0) {
            insert.setNull(4, java.sql.Types.INTEGER);
        } else {
            insert.setInt(4, mensagem.getId_post());
        }

        if (mensagem.getId_midia() == 0) {
            insert.setNull(5, java.sql.Types.INTEGER);
        } else {
            insert.setInt(5, mensagem.getId_midia());
        }

        insert.setBoolean(6, mensagem.isEntregue());
        insert.setBoolean(7, mensagem.isVisualizado());
        insert.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, DeleteException {
        try{
            if (delete == null) {
                new MensagemDAO();
            }
            delete.setInt(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException( "Erro ao deletar mensagem");
        }
    }

    public List<Mensagem> show() throws SQLException, ClassNotFoundException {
        if (show == null) {
            new MensagemDAO();
        }
        ResultSet rs = show.executeQuery();
        List<Mensagem> mensagens = new java.util.LinkedList<Mensagem>();
        while (rs.next()) {
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
    }
}
