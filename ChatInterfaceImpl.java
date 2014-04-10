import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatInterfaceImpl extends UnicastRemoteObject implements ChatInterface{

	private ArrayList<MessageInterface> refs = new ArrayList<MessageInterface>();
	private ArrayList<String> names = new ArrayList<String>();

	public ChatInterfaceImpl() throws RemoteException{
		super();
	}

	public void message(String sender, String msg) throws RemoteException{
		MessageInterface obj = refs.get(names.indexOf(sender));
		for(MessageInterface mi : refs){
			if(!mi.equals(obj))
				mi.showMessage(sender, msg);
		}
	}

	public void joinGroup(String name, MessageInterface ref) throws RemoteException{
		names.add(name);
		refs.add(ref);
		for(MessageInterface mi : refs){
			mi.print(name + " esta online.");
		}

	}

	public void leaveGroup(String name) throws RemoteException{
		MessageInterface obj = refs.get(names.indexOf(name));
		refs.remove(obj);
		names.remove(name);
		for(MessageInterface mi : refs){
			mi.print(name + " saiu.");
		}
	}

	public void listOnline(String name) throws RemoteException{
		String online = "";
		for(String nameOnline : names){
			online += nameOnline +"\n";
		}
		MessageInterface obj = refs.get(names.indexOf(name));
		obj.print(online);
	}

}
