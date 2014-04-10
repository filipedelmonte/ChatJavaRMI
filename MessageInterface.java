import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageInterface extends Remote{
	void showMessage(String remetente, String msg) throws RemoteException;
	void print(String str) throws RemoteException;
}
