package src.main.java.app;
import src.main.java.model.ContaBancariaModel;
import src.main.java.dao.ContaBancariaDAO;
import java.util.Scanner;

public class Aplicacao {

    public static void verificaResposta(int resp) {
        switch (resp) {
            case 1:
                Scanner ler = new Scanner(System.in);

                System.out.print("\nInsira ID: ");
                int idConta = ler.nextInt();

                System.out.print("Insira Nome: ");
                String nomePessoa = ler.next();

                System.out.print("Insira Cpf: ");
                String cpf = ler.next();

                System.out.print("Insira Cidade: ");
                String cidade = ler.next();
                
                ContaBancariaDAO insercao = new ContaBancariaDAO();
                insercao.inserir(idConta, nomePessoa, cpf, cidade);
                break;

            case 2: 

                System.out.println("\nDeposito concluido\n");   

                break;

            case 3: 

                System.out.println("\nTransferencia realizada\n");

                break;

            case 4: 

                System.out.println("\nSeus registros\n");
                break;

            case 5: 
                System.out.println("\nAtualizar registros\n");
                break;
            case 6:
                System.out.println("\nDeletar Registros\n");
                break;

            default:

                System.out.println("\nOpção invalida\n");
                break;
        }
    }
        
    
    public static void main(String[] args){
        /*ContaBancariaModel model = new ContaBancariaModel(1, "Carlos", "13913305602", "Belo Horizonte");
        System.out.println(model.toString());*/

        int resposta = -1;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("==============================\n" +
            "Menu de Usuario:\n\n" +
            "1.Abrir conta\n"+
            "2.Depositar\n"+
            "3.Transferir\n"+
            "4.Ver registros\n"+
            "5.Atualizar registro\n"+
            "6.Deletar registro\n"+
            "0.Sair"+
            "\n==============================");

            System.out.print("--> ");

            resposta = entrada.nextInt();
            if(resposta != 0){verificaResposta(resposta);}
            // resposta = 0;
        } while (resposta != 0);

        entrada.close();

    }
}
