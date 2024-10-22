package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
        ServerSocket server = new ServerSocket(3000);

        int number = generateRandomNumber();

        do {
            Socket socket = server.accept();
            ClientHandler client = new ClientHandler(socket, number);
            client.start();
        } while (true);
    }

    public static int generateRandomNumber() {
        return new Random().nextInt(100);
    }
}