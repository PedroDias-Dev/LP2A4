import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
    private Socket cliente1;
    private Socket cliente2;

    public ServerThread(Socket cliente1, Socket cliente2) {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
    }
    @Override
    public void run() {
        PrintStream saida = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(cliente1.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            saida = new PrintStream(cliente2.getOutputStream());

            while (true) {
                String message = reader.readLine();
                System.out.println(message);
                saida.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
