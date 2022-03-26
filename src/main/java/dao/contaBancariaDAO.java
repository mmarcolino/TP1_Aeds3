package src.main.java.dao;
import src.main.java.model.ContaBancariaModel;

public class ContaBancariaDAO{

    /**
     * 
     */
    public void  inserir(int id, String nome, String cpf,String cidade){
        ContaBancariaModel conta = new ContaBancariaModel(id, nome, cpf, cidade);
        System.out.println(conta.toString() + "\n"); // Tava aqui de teste essa merda 
        // Scanner ler = new Scanner(System.in);

        
    }
    
}
