package remote.naming;

import remote.*;
import java.rmi.Naming;
import java.util.Scanner;

public class MensagemClienteNaming {

    public static void main(String[] args) {
        try {
                Mensagem mensagem = (Mensagem) Naming.lookup("rmi://localhost/Mensagem");
            System.out.println("Cliente Criado...");
            System.out.println("Mensagem : " + mensagem.getMensagem());
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
