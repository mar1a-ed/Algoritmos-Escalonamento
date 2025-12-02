package SOEscalonamento;

public class PP extends Algoritmo{
    
    public void addTarefa(int qtd){
     
        System.out.printf("Tarefa - Informe: \n");
        System.out.print("Id: ");
        id = sc.nextInt();
        System.out.print("Início: ");
        inicio = sc.nextInt();
        System.out.print("Duração: ");
        duracao = sc.nextInt();
        System.out.print("Prioridade: ");
        prioridade = sc.nextInt();
        
        System.out.println("------------------------");
    }
    
    public void execucao(Algoritmo[] tarefas){
        
        ordenaTarefas(tarefas);
        
        int tempoAtual = 0, feitas = 0;
        int[] acabou = new int[tarefas.length];
        
        while(feitas < tarefas.length){
            int posicao = -1;
            
            for(int i=0;i<tarefas.length;i++){
                if(acabou[i] == 0 && tarefas[i].getInicio() <= tempoAtual){
                    posicao = i;
                    break;
                }
            }
            
            if(posicao==-1){
                tempoAtual++;
                continue;
            }
            
            
            Algoritmo tarefaAtual = tarefas[posicao];
            
            System.out.printf("#T%d | %d | %d",tarefaAtual.getId(),tempoAtual,tempoAtual + tarefaAtual.getDuracao());
            
            tempoAtual += tarefaAtual.getDuracao();
            acabou[posicao] = 1;
            
            feitas++;
                       
            
        }
        
        
        
    }
    
}
