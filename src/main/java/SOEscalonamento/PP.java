package SOEscalonamento;

public class PP extends Algoritmo{
    
    public void addTarefa(int qtd){
     
        //informa os dados necessários de cada tarefa
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
        
        ordenaTarefas(tarefas); //ordena as tarefas por prioridade
        
        int tempoAtual = 0, feitas = 0; //inicializa o tempo atual e o numero de tarefas concluidas com 0
        int[] acabou = new int[tarefas.length]; //cria um vetor para guardar a informação se a tarefa foi concluida ou não
        
        while(feitas < tarefas.length){ //enquanto o numero de tarefas concluidas for menor que a quantidade de tarefas do vetor
            int posicao = -1; //inicializa a posição inicial como -1 (posição anterior a primeira)
            
            for(int i=0;i<tarefas.length;i++){ //percorre o vetor
                if(acabou[i] == 0 && tarefas[i].getInicio() <= tempoAtual){ //verifica se a tarefa foi feita E se a tarefa ja iniciou
                    posicao = i;
                    break;
                }
            }
            
            if(posicao==-1){ //nao iniciou, incrementa o tempo atual e procura a proxima
                tempoAtual++;
                continue; //evita que o programa acesse a posição -1
            }
            
            
            Algoritmo tarefaAtual = tarefas[posicao]; //instancia um objeto de tarefa atual como a posição achada para começar a ser executada
            
            System.out.printf("#T%d | %d | %d",tarefaAtual.getId(),tempoAtual,tempoAtual + tarefaAtual.getDuracao()); //printa cada tarefa (Id, Início, Duração/Tempo Final)
            
            tempoAtual += tarefaAtual.getDuracao(); //soma o tempo para executar a tarefa no tempo finalizado
            acabou[posicao] = 1; //atualiza a posição da tarefa executada como 1, ou seja, verdadeiro, foi executada
            
            feitas++; //incrementa o total de tarefas concluidas
                       
            
        }
        
        
        
    }
    
}
