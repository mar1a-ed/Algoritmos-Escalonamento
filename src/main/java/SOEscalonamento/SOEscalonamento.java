package SOEscalonamento;

import java.util.Scanner;

public class SOEscalonamento {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Algoritmo[] tarefas;
        
        System.out.print("Número de Tarefas: ");
        int qtd = sc.nextInt();
        
        tarefas = new Algoritmo[qtd];
        
        System.out.println("[p] - Por Prioridade Sem Preempção.");
        System.out.println("[r] - Round Robin Com Prioridade Quantum = 2.");
        char opcao = sc.next().charAt(0);        
        
        if(opcao=='p'){
            for(int i=0;i<qtd;i++){
                PP pp = new PP();
                pp.addTarefa(i);
                tarefas[i] = pp;
            }
            
            
            System.out.println("\n-------------PP--------------");
            System.out.println(" #T | I | F");
            System.out.println("-----------------------------");
            PP roda = new PP();
            roda.execucao(tarefas);
        
        
        }
        
    }
    
}
