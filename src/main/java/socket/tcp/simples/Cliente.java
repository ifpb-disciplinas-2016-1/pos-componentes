package socket.tcp.simples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Job
 */
public class Cliente {
        public static void main(String[] args){
             try{
                Socket client = new Socket("localhost",9999);
//                OutputStream os = client.getOutputStream();
//                PrintWriter out = new PrintWriter(os);
                InputStream is = client.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);
                BufferedReader in = new BufferedReader(reader);
                System.out.println(in.readLine());
                in.close();
//                ObjectInputStream input = new ObjectInputStream(is);
//                ArrayList list =(ArrayList) input.readObject();
//                is.close();
                //out.close();
//                os.close();
                client.close();
             }
             catch(Exception e) {e.printStackTrace();}
        }

}
