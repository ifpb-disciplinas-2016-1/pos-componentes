package remote.registry;

import remote.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MensagemClienteRegistry {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry
                    .getRegistry("localhost", 14088);

            Mensagem stub = (Mensagem) registry.lookup("Mensagem");
            System.out.println("Cliente Criado...");
            System.out.println("Mensagem : " + stub.getMensagem());
            // Algo somente para deixar o cliente fucionando
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
