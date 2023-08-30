import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int porta = 3334;
            ServerSocket servidor = new ServerSocket(porta);
            System.out.println("servidor iniciado! rodando na porta: " + porta);

            Socket cliente1;
            Socket cliente2;

            while (true) {
                cliente1 = servidor.accept();
                System.out.println("cliente conectado: " + cliente1.getInetAddress());

                cliente2 = servidor.accept();
                System.out.println("cliente conectado: " + cliente2.getInetAddress());

                ServerThread server = new ServerThread(cliente1, cliente2);
                server.start();

                ServerThread server2 = new ServerThread(cliente2, cliente1);
                server2.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}