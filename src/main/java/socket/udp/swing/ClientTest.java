package socket.udp.swing;

/**
 *
 * @author Ricardo Job
 */
import javax.swing.JFrame;

public class ClientTest {

    public static void main(String args[]) {
        Client application = new Client();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.waitForPackets();
    }
}



