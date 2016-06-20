package socket.udp.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Ricardo Job
 */
public class Servidor {

    public static void main(String[] args) {

        try {
            System.out.println("Servidor");
            int porta = 1234;
            MulticastSocket msocket = new MulticastSocket(porta);
            InetAddress grupo = InetAddress.getByName("230.1.2.25");
            msocket.joinGroup(grupo);
            byte[] dados = new byte[100];
            DatagramPacket pacote = new DatagramPacket(dados, dados.length);
            System.out.println("Esperando pela mensagem");
            msocket.receive(pacote);
            System.out.println("Mensagem: " + new String(pacote.getData(), 0, pacote.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
