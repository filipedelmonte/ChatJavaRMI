import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote{
	void message(String sender,String msg) throws RemoteException;
	void joinGroup(String name, MessageInterface ref) throws RemoteException;
	void listOnline(String name) throws RemoteException;
	void leaveGroup(String name) throws RemoteException;
}
