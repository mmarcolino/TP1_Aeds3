package src.main.java.app;
import src.main.java.model.ContaBancariaModel;

public class Aplicacao {
    
    public static void main(String[] args){
        ContaBancariaModel model = new ContaBancariaModel(1, "Carlos", "13913305602", "Belo Horizonte");
        System.out.println(model.toString());
    }
}
