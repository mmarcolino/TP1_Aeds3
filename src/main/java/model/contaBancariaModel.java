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

    // Setters.......................//

    public void setIdConta(String id){
        this.idConta = id;
    }

    public void setNomePessoa(String nome){
        this.nomePessoa = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    private void setTranferenciasRealizada(int transferencias){
        this.transefernciasRealizadas = transferencias;
    }

    private void setSaldo(float saldo){
        this.saldoConta = saldo;
    }

    //getters........................//

    public String getIdConta(){
        return idConta;
    }

    public String getNomePessoa(){
        return nomePessoa;
    }

    public String getCpf(){
        return cpf;
    }

    public String getCidade(){
        return cidade;
    }

    public int getTranferenciasRealizada(){
        return transefernciasRealizadas;
    }

    public float getSaldo(){
        return saldoConta;
    }

    public void novaConta(String id, String nome, String cpf,String cidade){
        this.idConta = id;
        this.nomePessoa = nome;
        this.cpf = cpf;
        this.cidade = cidade;
    }

     
}
