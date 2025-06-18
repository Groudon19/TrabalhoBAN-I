package dados;

public class Midia {
    private int id_midia;
    private int tamanho;
    private int tipo;
    private int duracao;

    public Midia(int id_midia, int tamanho, int tipo, int duracao) {
        this.id_midia = id_midia;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.duracao = duracao;
    }

    public Midia(int id_midia, int tamanho, int tipo) {
        this.id_midia = id_midia;
        this.tamanho = tamanho;
        this.tipo = tipo;
    }

    public Midia() {
    }

    public int getId_midia() {
        return id_midia;
    }
    public void setId_midia(int id_midia) {
        this.id_midia = id_midia;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    @Override
    public String toString() {
        return "midia [id_midia=" + id_midia + ", tamanho=" + tamanho + ", tipo=" + tipo + ", duracao=" + duracao + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Midia other = (Midia) obj;
        if (id_midia != other.id_midia)
            return false;
        return true;
    }

    
}
