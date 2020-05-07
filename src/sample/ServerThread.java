package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import sample.DatabaseHandler;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            DatabaseHandler dh = null;
            while (true) {
                try {
                    if (!((dh = (DatabaseHandler) inputStream.readObject()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (dh.getOperationType().equals("sample.fxml")) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

