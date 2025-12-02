package SOEscalonamento;

import java.util.Scanner;

public class SOEscalonamento {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //inicializa a classe scanner para ler as opções do usuário
        Algoritmo[] tarefas; //cria o vetor
        
        System.out.print("Número de Tarefas: "); //usuário entra com o número de tarefas desejado
        int qtd = sc.nextInt();
        
        tarefas = new Algoritmo[qtd]; //inicializa o vetor com a quantidade de tarefas informado 
        
        //escolhe o algoritmo que irá executar as tarefas
        System.out.println("[p] - Por Prioridade Sem Preempção.");
        System.out.println("[r] - Round Robin Com Prioridade Quantum = 2.");
        char opcao = sc.next().charAt(0);        
        
        switch (opcao) {
            case 'p' -> {
                for(int i=0;i<qtd;i++){
                    PP pp = new PP(); //objeto do algoritmo 'Por Prioridade Sem Preempção'
                    pp.addTarefa(i); //adiciona a tarefa no vetor
                    tarefas[i] = pp; //instacia o objeto para o vetor original
                }   
                System.out.println("\n--------------PP----------------");
                System.out.println(" #T | I | F");
                System.out.println("-----------------------------");
                PP roda = new PP();
                roda.execucao(tarefas); //executa o algoritmo
                break;
            }
            case 'r' -> {
                for(int i=0;i<qtd;i++){
                    RR rr = new RR();
                    rr.addTarefa(i);
                    tarefas[i] = rr;
                }
                System.out.println("\n--------------RR---------------");
                RR roda = new RR();
                roda.execucao(tarefas);
                break;
            }
            default -> System.out.println("Opção Inválida!");
        }
        
        sc.close();
        
    }
    
}
