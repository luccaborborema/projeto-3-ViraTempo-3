package compromisso;

public class Compromisso {
        private String nome;
        private String horaComeco;
        private String horaFim;

    public Compromisso(String nome, int a, int b, int c, int d) {
        this.nome = nome;
        this.horaComeco = (a + ":" + b);
        this.horaFim = (c + ":" + d);
    }

    public String getNome() {
        return this.nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getHoraFim() {
        return this.horaFim;
    }
    public void setHoraFim(int a, int b) {
        this.horaFim = (a + ":" + b);
    }
    public String getHoraComeco() {
        return this.horaComeco;
    }
    public void setHoraComeco(int a, int b) {
        this.horaComeco = (a + ":" + b);
    }
}