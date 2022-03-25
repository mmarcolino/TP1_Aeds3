package src.main.java.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ContaBancariaModel {
    private int idConta;
    private String nomePessoa;
    private String cpf;
    private String cidade;
    private int transefernciasRealizadas;
    private float saldoConta;

    public ContaBancariaModel(){
    
    }

    public ContaBancariaModel(int id, String nome, String cpf,String cidade){
    this.idConta = id;
    this.nomePessoa = nome;
    this.cpf = cpf;
    this.cidade = cidade;
    }


    // Setters.......................//

    public void setIdConta(int id){
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

    public int getIdConta(){
        return this.idConta;
    }

    public String getNomePessoa(){
        return this.nomePessoa;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getCidade(){
        return this.cidade;
    }

    public int getTranferenciasRealizada(){
        return this.transefernciasRealizadas;
    }

    public float getSaldo(){
        return this.saldoConta;
    }

    /*
    public void recebe(){

    }

    public void transfere(){
        
    }
    */
    
    @Override
    public String toString() {
        if (this.idConta >= 0) {
            return "\nId: " + this.idConta + "\nNome: " + this.nomePessoa + "\nCPF: " + this.cpf
                    + "\nCidade: " + this.cidade + "\nTransefernciasRealizadas: " + this.transefernciasRealizadas +
                    "\nSaldoConta: " + this.saldoConta;
        } else {
            return null;
        }
    }
     
    public byte[] toByteArray() throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(this.idConta);
        dos.writeUTF(this.nomePessoa);
        dos.writeUTF(this.cpf);
        dos.writeUTF(this.cidade);
        dos.writeInt(this.transefernciasRealizadas);
        dos.writeFloat(this.saldoConta);

      /*  if (baos.toByteArray().length <= registerSize) {
            byte[] tailLength = new byte[registerSize - baos.toByteArray().length];
            dos.write(tailLength);
        } else {
            throw new IndexOutOfBoundsException("Prontuário excede limite de tamanho.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    */
        return baos.toByteArray();
    }

    public void readFromByteArray(byte[] byteArray) throws IOException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        DataInputStream dataInputSteam = new DataInputStream(byteArrayInputStream);

        this.idConta = dataInputSteam.readInt();
        this.nomePessoa = dataInputSteam.readUTF();
        this.cpf = dataInputSteam.readUTF();
        this.cidade = dataInputSteam.readUTF();
        this.transefernciasRealizadas = dataInputSteam.readInt();
        this.saldoConta = dataInputSteam.readInt();

        /*
        try {
            if (dis.readChar() != '*') {
                this.setCodigo(dis.readInt());
                this.setNome(dis.readUTF());
                Date date = new Date(dis.readLong());
                this.setDataNascimento(date);
                this.setSexo(dis.readChar());
                this.setAnotacoes(dis.readUTF());
            } else {
                this.setCodigo(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
