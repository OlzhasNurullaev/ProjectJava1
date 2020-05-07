package sample;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        try{
            ServerSocket serverSocket=new ServerSocket(499);

            System.out.println("Waiting for a client!");

            Socket socket=serverSocket.accept();
            System.out.println("Client connected!");

            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            String message=" ";

            while ((message = (String)inputStream.readObject())!=null){
                System.out.println(message);
                if(message.equals("hello")){
                    outputStream.writeObject("Hello!");
                }else if(message.equals("bye")){
                    outputStream.writeObject("Bye bye!");
                }else{
                    outputStream.writeObject(null);
                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
