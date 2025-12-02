package SOEscalonamento;

import java.util.Scanner;

public class Algoritmo {
    protected Integer id;
    protected Integer inicio;
    protected Integer duracao;
    protected Integer prioridade;

    Scanner sc = new Scanner(System.in);
    
    public Algoritmo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
    
    public void ordenaTarefas(Algoritmo[] tarefas){
        Algoritmo temp;
         
        for(int i=0;i<tarefas.length-1;i++){
            for(int j=i+1;j<tarefas.length;j++){
                if(tarefas[j].getPrioridade()>tarefas[i].getPrioridade()){
                    temp = tarefas[i];
                    tarefas[i] = tarefas[j];
                    tarefas[j] = temp;
                }
            }
        }
    }
    
}
