package dados;

public class Conversa {
    private int id_conversa;
    private String nome_conversa;
    
    public int getId_conversa() {
        return id_conversa;
    }
    public void setId_conversa(int id_conversa) {
        this.id_conversa = id_conversa;
    }
    public String getNome_conversa() {
        return nome_conversa;
    }
    public void setNome_conversa(String nome_conversa) {
        this.nome_conversa = nome_conversa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conversa other = (Conversa) obj;
        if (id_conversa != other.id_conversa)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "conversa [id_conversa=" + id_conversa + ", nome_conversa=" + nome_conversa + "]";
    }

    
}
