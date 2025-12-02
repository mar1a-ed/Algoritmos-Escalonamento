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
        Algoritmo temp; //objeto auxiliar para fazer a troca
         
        /* foi utilizado o método de ordenação 'Bubble Sort' para ordenar as tarefas
        conforme a prioridade (foi usado o critério de quanto maior o número da prioridade, maior a prioridade)*/
        
        for(int i=0;i<tarefas.length-1;i++){ //percorre o vetor 
            for(int j=i+1;j<tarefas.length;j++){ //percorre o vetor a partir da posição posterior à inicial
                if(tarefas[j].getPrioridade()>tarefas[i].getPrioridade()){ //verifica se a prioridade da posição posterior, é maior que a prioridade da posição anteriro
                    //realiza a troca, se necessário
                    temp = tarefas[i]; 
                    tarefas[i] = tarefas[j];
                    tarefas[j] = temp;
                }
            }
        }
    }
    
}
