package remote.registry;

import remote.*;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class MensagemServerRegistry {

    public static void main(String[] args) {
        try {
            Mensagem skeleton = new MensagemTrafegaRede("Alguma Coisa");
            //Exportando o objeto para esta porta
//            Remote stub = UnicastRemoteObject.exportObject(skeleton,8787);
            Registry registry = LocateRegistry.createRegistry(14088);
            registry.rebind("Mensagem", skeleton);
            System.out.println("Servidor Pronto");
            Scanner leitor = new Scanner(System.in);
            int valor = leitor.nextInt();
            if (valor == 0) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
