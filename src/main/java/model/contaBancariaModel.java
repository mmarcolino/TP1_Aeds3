package src.main.java.model;

public class contaBancariaModel {
    String idConta;
    String nomePessoa;
    String cpf;
    String cidade;
    int transefernciasRealizadas;
    float saldoConta;

    public contaBancariaModel(){
        idConta = "";
        nomePessoa = "";
        cpf = "";
        cidade = "";
        transefernciasRealizadas = 0;
        saldoConta = 0;
    }
}
