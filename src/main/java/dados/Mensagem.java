package dados;

import java.sql.Timestamp;

public class Mensagem {
    private int id_mensagem;
    private Timestamp data_hora;
    private String texto;
    private int id_usuario;
    private int id_post;
    private int id_midia;
    private boolean entregue;
    private boolean visualizado;

    public Mensagem(int id_mensagem, Timestamp data_hora, String texto, int id_usuario, int id_post, int id_midia, boolean entregue, boolean visualizado) {
        this.id_mensagem = id_mensagem;
        this.data_hora = data_hora;
        this.texto = texto;
        this.id_usuario = id_usuario;
        this.id_post = id_post;
        this.id_midia = id_midia;
        this.entregue = entregue;
        this.visualizado = visualizado;
    }

    public Mensagem() {
        // Construtor vazio
    }

    public int getId_mensagem() {
        return id_mensagem;
    }

    public void setId_mensagem(int id_mensagem) {
        this.id_mensagem = id_mensagem;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_midia() {
        return id_midia;
    }

    public void setId_midia(int id_midia) {
        this.id_midia = id_midia;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mensagem other = (Mensagem) obj;
        if (id_mensagem != other.id_mensagem)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "mensagem [data_hora=" + data_hora + ", texto=" + texto + "]";
    }

    

    
    
}
