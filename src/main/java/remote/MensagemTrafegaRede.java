package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Todos os exemplos os servidor exporta o objeto remoto diretamente
//public class MensagemTrafegaRede  implements Mensagem {
public class MensagemTrafegaRede extends UnicastRemoteObject implements Mensagem {

    private String mensagem;

    public MensagemTrafegaRede() throws RemoteException {
    }

    public MensagemTrafegaRede(String mensagem) throws RemoteException {
        this.mensagem = mensagem;
    }

    public String getMensagem() throws RemoteException {
        return this.mensagem;
    }
}
