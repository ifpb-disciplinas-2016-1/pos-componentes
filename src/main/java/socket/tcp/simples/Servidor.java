package socket.tcp.simples;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Job
 */
public class Servidor {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9999)) {
            System.out.println("Servidor Criado");
            Socket client = server.accept();
            System.out.println("Cliente Conectado");
            OutputStream os = client.getOutputStream();
//            ObjectOutputStream saida = new ObjectOutputStream(os);
            PrintWriter out = new PrintWriter(os, true);
            out.println("Mensagem enviada pelo Servidor");
            out.close();

//            saida.writeObject(new ArrayList());
//            os.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
