package socket.udp.simple;

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
            DatagramSocket socket = new DatagramSocket();
            //Destino
            InetAddress destino = InetAddress.getByName("127.0.0.1");
            int porta = 1234;
            //Informações msg
            String mensagem = "Outra mensagem";
            byte[] dados = mensagem.getBytes();
            DatagramPacket pacote = new DatagramPacket(dados, dados.length,
                    destino, porta);
            socket.send(pacote);
            System.out.println("Mensagem enviada");
            byte[] dadosRecebidos = new byte[14];
            DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
            socket.receive(pacoteRecebido);
            System.out.println("Recebido: " + new String(pacoteRecebido.getData()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
