import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main (String[] args){
        try {
            Socket cliente = new Socket("localhost", 3334);

            ChatWriteThread writeThread = new ChatWriteThread(cliente);
            writeThread.start();

            ClienteThread readThread = new ClienteThread(cliente);
            readThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
