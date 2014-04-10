import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class ChatServer{

	public static void main(String args[]){
		try{
			System.setProperty("java.rmi.server.hostname", "localhost");
			ChatInterfaceImpl obj = new ChatInterfaceImpl();
			Registry registry = LocateRegistry.getRegistry("localhost");
			registry.rebind("ChatServer", obj);
			System.out.println("Server is bound to registry");
		}catch(RemoteException e){
			System.out.println("ChatClient server error: "+e.getMessage());
		}
	}

}
