package socket.udp.multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Ricardo Job
 */
public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Cliente");
            int porta = 1234;
            DatagramSocket socket = new DatagramSocket();
            InetAddress grupo = InetAddress.getByName("127.0.0.1");
            String mensagem = "Hello";
            byte[] dados = mensagem.getBytes();
            DatagramPacket pacote = new DatagramPacket(dados, dados.length, grupo, porta);
            socket.send(pacote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
