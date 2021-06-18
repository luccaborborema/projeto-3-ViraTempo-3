package tarefa;

public class Tarefa {
    private String nome;
    private String duracao;

    public Tarefa(String nome, String duracao) {
            this.duracao = duracao;
            this.nome = nome;
    }

    public String getDuracao() {
            return this.duracao;
    }
    public void setDuracao(String duracao) {
            this.duracao = duracao;
    }

    public String getNome() {
            return this.nome;
    }
    public void setnome(String nome) {
            this.nome = nome;
    }

}