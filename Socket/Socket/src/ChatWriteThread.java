import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatWriteThread extends Thread{
    private Socket cliente;

    public ChatWriteThread(Socket cliente) {
        this.cliente = cliente;
    }
    @Override
    public void run() {
        PrintStream saida = null;
        try {
            Scanner scanner = new Scanner(System.in);
            saida = new PrintStream(cliente.getOutputStream());

            while (true) {
                String message = scanner.nextLine();
                saida.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
