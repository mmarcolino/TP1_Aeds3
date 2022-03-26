package src.main.java.fileManager;

import java.io.RandomAccessFile;
import src.main.java.model.*;

public class Manager {
    private String path = ""; 

    public Manager(String path){
        this.path = path;
    }

    public static void createNewDB(String path){
        RandomAccessFile arq;
        
        try{
            arq = new RandomAccessFile(path, "rw");
            arq.close();
        }catch(Exception e){
            System.out.println("ERROR" + e);
        }
    }

    public  int getMaxId(){
        int maxId = 0;
        RandomAccessFile arq;
        createNewDB(this.path);

        try{
            arq = new RandomAccessFile(path, "rw");
            arq.seek(0);
            if(arq.length() != 0){
                maxId = arq.readInt();
            }
            arq.close();
            return maxId;
        }catch (Exception e){

        }
        return maxId;
    }

    public int addMaxId(){
        int maxId = 0;
        RandomAccessFile arq;
        try {
            maxId = getMaxId();
            maxId++;
            arq = new RandomAccessFile(this.path, "rw");
            arq.seek(0);
            arq.writeInt(maxId);
        } catch (Exception e) {
            
        }
        return maxId;
    }

    public static long handlePointer(int id){
        long position = -1;
        RandomAccessFile arq;
        String dbPath = "../resources/bank.db";

        try {
            arq = new RandomAccessFile(dbPath, "rw");
            arq.seek(0);
            int maxId = arq.readInt();
            if (id <= maxId) {
                long pointer = arq.getFilePointer();
                int searchPointer = 0;
                while (pointer < arq.length() -4) {
                    boolean lapide = arq.readBoolean();
                    int tam = arq.readInt();

                    searchPointer = arq.readInt();
                    pointer = arq.getFilePointer();

                    if (searchPointer != id || !lapide) {
                        pointer += tam -4;
                        arq.seek(pointer);
                    } else {
                        pointer -= 8;
                        position = pointer;
                        break;
                    }
                }
            }
            arq.close();
        } catch (Exception e) {
        }

        return position;
    }
    public boolean create(byte[] byteArray){
        RandomAccessFile arq;
        try {
            arq = new RandomAccessFile(path, "rw");
            arq.seek(arq.length());
            arq.writeBoolean(true);
            arq.writeInt(byteArray.length);
            arq.write(byteArray);
            arq.close();
        } catch (Exception e) {
        }
        return true;
    }

    public static ContaBancariaModel read(int id){
        byte[] byteArray;
        RandomAccessFile arq;
        ContaBancariaModel conta = new ContaBancariaModel();
        String path = "../resources/bank.db";

        if(handlePointer(id) == -1 || id <= 0){
            return conta;
        }

        try {
            arq = new RandomAccessFile(path, "rw");
            arq.seek(handlePointer(id));
            int tam = arq.readInt();
            byteArray = new byte [tam];
            arq.read(byteArray);
            arq.close();
        } catch (Exception e) {
        }
        return conta;
    }

    public boolean update(byte[] byteArray, int id){
        RandomAccessFile arq;
        if (byteArray.length == 0 || handlePointer(id) == -1){
            return false;
        }

        try{
            arq = new RandomAccessFile(path, "rw");
            arq.seek(handlePointer(id));
            int tam = arq.readInt();

            if (byteArray.length <= tam) {
                arq.write(byteArray);
              } else {
                delete(id);
                create(byteArray);
              }
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    public boolean delete(int id){
        RandomAccessFile arq;
        boolean tf = false;

            try{
                arq = new RandomAccessFile(path, "rw");
                long pos = handlePointer(id) - 1;
        
                if (pos > 0) {
                arq.seek(pos);
                arq.writeBoolean(false);
                tf = true;
            }
                arq.close();
            }catch (Exception e) {}
        return tf;
    }
}
