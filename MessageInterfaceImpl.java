import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MessageInterfaceImpl extends UnicastRemoteObject implements MessageInterface{

	public MessageInterfaceImpl() throws RemoteException{
		super();
	}

	public void showMessage(String remetente, String msg) throws RemoteException{
		System.out.println(remetente + ":  " + msg);
	}

	public void print(String str) throws RemoteException{
		System.out.println(str);
	}
}

