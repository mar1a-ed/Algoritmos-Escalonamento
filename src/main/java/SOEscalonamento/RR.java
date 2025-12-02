package SOEscalonamento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RR extends Algoritmo{
    
    private final int quantum = 2; //variavel que guarda o valor do quantum
    
    public void addTarefa(int qtd){
        
        //adiciona dados das tarefas
        
        System.out.println("Tarefa - Informe:");
        System.out.print("Id: ");
        id = sc.nextInt();
        System.out.print("Início: ");
        inicio = sc.nextInt();
        System.out.print("Duração: ");
        duracao = sc.nextInt();
        System.out.print("Prioridade: ");
        prioridade = sc.nextInt();
        System.out.println("-----------------------");
    }
    
    public void execucao(Algoritmo[] tarefas){
        int tempoAtual = 0, feitas = 0; //tempo que está e quantidade de tarefas concluidas
        List<Algoritmo> pronto = new ArrayList<>(); //lista para guardar as tarefas que estão no estado de pronto
        List<Algoritmo> faltantes = new ArrayList<>(); //lista para guardar as tarefas que faltam para serem executadas totalmente
        
        for(Algoritmo algoritmo: tarefas){ //percorre o vetor com tarefas
            algoritmo.setTempoFaltante(algoritmo.getDuracao()); //atualiza o tempo faltante inicial com a duracao da tarefa
            faltantes.add(algoritmo); //adiciona na lista para executar a tarefa
        }
        
        System.out.println("\n| --- ORDEM DE EXECUÇÃO (Bursts) --- |");
        System.out.println("| TAREFA | INÍCIO | FIM | DURAÇÃO |");
        System.out.println("|----------------------------------|");
        
        while(feitas<tarefas.length){ //enquanto tiver menos tarefas concluidas que o tamanho do vetor (quantidade total de tarefas)
            for(int i=0;i<faltantes.size();i++){
                Algoritmo algoritmo = faltantes.get(i);
                if(algoritmo.getInicio()<=tempoAtual){ 
                    pronto.add(algoritmo); 
                    faltantes.remove(i);
                    i--;
                }
            }
     
            pronto.sort(Comparator.comparingInt(Algoritmo::getPrioridade).thenComparingInt(Algoritmo::getInicio));
                                             
            if(pronto.isEmpty()){
                if(faltantes.isEmpty()){
                    break;
                }
            
                int prox = faltantes.stream().mapToInt(Algoritmo::getInicio).min().orElse(tempoAtual + 1);
            
                System.out.printf("| CPU OCIOSA | %d | %d | %d |\n", tempoAtual, prox, prox - tempoAtual);
                
                tempoAtual = prox;
                continue;
           }
            
            Algoritmo atual = pronto.remove(0);
            
            int tempoExecucao = Math.min(atual.getTempoFaltante(), quantum);
            int tempoFinal = tempoAtual + tempoExecucao;
            
            System.out.printf("|   Tarefa%d   |  %d   |  %d  |   %d   |\n",atual.getId(), tempoAtual, tempoFinal, tempoExecucao);
            
            tempoAtual += tempoExecucao;
            atual.setTempoFaltante(atual.getTempoFaltante() - tempoExecucao);
            
            if(atual.getTempoFaltante()==0){
                feitas++;
            }else{
                pronto.add(atual);
            }
            
        }
        
    }
}
