package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.example.lib.ResponseMessages;

public class ClientHandler extends Thread {
    private Socket socket;
    private int number;
    private String res;
    private int attempts = 0;

    public ClientHandler(Socket socket, int number) {
        this.socket = socket;
        this.number = number;

        // response is by default an "error request"
        this.res = ResponseMessages.getREQUEST_ERROR();
    }

    @Override
    public void run() {
        try {
            System.out.println("Client Connesso");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            do {
                // updating --> adding 1 to the number of tries
                attempts++;

                // waiting --> catch the client's guess
                int guess = Integer.parseInt(catchReq(in));

                // calculating --> get result
                getResult(guess);

                // sending --> sending the result (server response)
                sendRes(out, res);

                // sending --> sending the needed number of tries (server response)
                sendRes(out, Integer.toString(attempts)); 
            } while (!isCorrect(res));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String newLine() {
        return "\n";
    }

    public String catchReq(BufferedReader in) throws IOException {
        return in.readLine();
    }

    public void sendRes(DataOutputStream out, String res) throws IOException {
        out.writeBytes(res + newLine());
    }

    public boolean isCorrect(String res) {
        return res.equals(ResponseMessages.getGUESS_IS_CORRECT());
    }

    public void getResult(int guess) {
        if (guess < number) {
            res = ResponseMessages.getGUESS_IS_UNDER();
        }

        if (guess > number) {
            res = ResponseMessages.getGUESS_IS_OVER();
        }

        if (guess == number) {
            res = ResponseMessages.getGUESS_IS_CORRECT();
        }
    }
}