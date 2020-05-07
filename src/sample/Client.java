package sample;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        try {
            Socket socket = new Socket("localhost", 3306);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            System.out.println("Insert name:");
            String name = in.next();
            while (true) {
                System.out.println("1 - To send message");
                System.out.println("2 - To exit");
                System.out.println("3- to surprise");
                int choice = in.nextInt();


                if (choice == 1) {
                    System.out.println("insert Text:");
                    String txt = in.next();
                    outputStream.writeObject(name + " : " + txt);
                }

                if(choice==2){
                    break;
                }
                if(choice==3){
                    System.out.println("can you write hello or bye");
                    String txt = in.next();
                    String response = "";
                    outputStream.writeObject(txt);
                    if ((response = (String) inputStream.readObject()) != null) {
                        System.out.println(response);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}