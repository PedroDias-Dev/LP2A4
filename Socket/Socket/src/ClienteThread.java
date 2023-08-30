import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {
    private Socket cliente;

    public ClienteThread(Socket cliente) {
        this.cliente = cliente;
    }
    @Override
    public void run() {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(cliente.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String msg;
            do{
                msg = reader.readLine();

                if(msg == null) {
                    System.out.println(cliente.getLocalAddress() + " foi desconectado.");
                    cliente.close();
                    this.interrupt();
                    return;
                }

                System.out.println(cliente.getLocalAddress() + ": " + msg);
            } while (msg != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
