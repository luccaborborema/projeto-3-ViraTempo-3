package usuario;
import java.util.ArrayList;
import tarefa.Tarefa;
import compromisso.Compromisso;

public class Usuario {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private ArrayList<Compromisso> compromissos = new ArrayList<>();

    public void setTarefa (Tarefa t) {
            tarefas.add(t);
    }

    public void getTarefas() {
        for (Tarefa t : tarefas) {
            System.out.println("\t" + t.getNome() + " - " + t.getDuracao());
            System.out.print("\n");

        }
    }

    public void setCompromisso (Compromisso c) {
            compromissos.add(c);
    }

    public void getCompromissos() {
        for (Compromisso c : compromissos) {
                System.out.println("\t" + c.getNome() + " - " + c.getHoraComeco() + " - " + c.getHoraFim());
                System.out.print("\n");
        	}
    }
    public String getStringC() {
    	String xyz = "";
        for (Compromisso c : compromissos) {
        	xyz = xyz + c.getNome() + " - " + c.getHoraComeco() + " - " + c.getHoraFim() + "\n";	
        }
        return xyz;
    }
    public String getStringT() {
    	String abc = "";
        for (Tarefa t : tarefas) {
        	abc = abc + t.getNome() + " - " + t.getDuracao() + "\n";	
        }
        return abc;
    }

}