package socket.udp.swing;

/**
 *
 * @author Ricardo Job
 */
import javax.swing.JFrame;

public class ServerTest {

    public static void main(String args[]) {
        Server application = new Server();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.waitForPackets();
    }
}
