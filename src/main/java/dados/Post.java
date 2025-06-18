package dados;

public class Post {
    private int id_post;
    private int id_usuario;
    private String data_hora;
    private String legenda;

    public Post(int id_post, int id_usuario, String data_hora, String legenda) {
        this.id_post = id_post;
        this.id_usuario = id_usuario;
        this.data_hora = data_hora;
        this.legenda = legenda;
    }

    public Post(int id_post, int id_usuario, String data_hora) {
        this.id_post = id_post;
        this.id_usuario = id_usuario;
        this.data_hora = data_hora;
    }

    public Post() {
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    @Override
    public String toString() {
        return "post [id_post=" + id_post + ", id_usuario=" + id_usuario + ", data_hora=" + data_hora + ", legenda="
                + legenda + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id_post != other.id_post)
            return false;
        return true;
    }

    
}
