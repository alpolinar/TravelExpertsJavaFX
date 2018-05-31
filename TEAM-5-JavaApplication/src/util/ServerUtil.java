package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ServerUtil {
    
    private String ADDRESS;
    private final int PORT;
    
    public ServerUtil() {
        this.PORT = 3001;
    }
    
    public boolean checkDirectory(){
        File dir = new File("server");
        return dir.exists();
    }
    
    public void createDirectory(){
        File dir = new File("server");
        if(!dir.exists())
            dir.mkdir();
    }
    
    public boolean serverCheck(){
        try{
            Socket server = new Socket();
            server.connect(new InetSocketAddress(getServerDetails(), PORT), 1000);
            return true;
        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }
        return false;
    }
    
    public void createServerFile(String address){
        try(PrintWriter pw = new PrintWriter(new File("server/server.txt"))){
            pw.write(address);
        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }
    }
    
    public boolean checkServerFile(){
        File file = new File("server/server.txt");
        return file.exists();
    }
    
    public String getFilePath(String fileName){
        File file = new File("server/"+fileName);
        return file.getPath();
    }
    
    public String getServerDetails(){
        String fileName = "server.txt";
        try(FileReader reader = new FileReader(getFilePath(fileName))){
            BufferedReader buffer = new BufferedReader(reader);
            ADDRESS = buffer.readLine();
        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }
        return ADDRESS;
    }
}
