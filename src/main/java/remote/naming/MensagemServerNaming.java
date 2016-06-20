package remote.naming;

import remote.*;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public class MensagemServerNaming {

    public static void main(String[] args) {
        try {
            Mensagem mensagem = new MensagemTrafegaRede("Alguma Coisa 2");
            Remote stub = UnicastRemoteObject.exportObject(mensagem,2978);
            Naming.rebind("rmi://127.0.0.1/Mensagem", stub);
            System.out.println("Servidor Pronto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
