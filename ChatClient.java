import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatClient{

	public static void main(String args[]){

		ChatInterface obj = null;

		try{
			Registry registry = LocateRegistry.getRegistry("localhost");
			obj = (ChatInterface)registry.lookup("ChatServer");
			String name = args[0];
			System.out.println("Chat CLient Begining... ");
			MessageInterfaceImpl ref = new MessageInterfaceImpl();
			obj.joinGroup(name, ref);
		    Scanner scanner = new Scanner(System.in);
		    while(true){
		    	String cmd = scanner.nextLine();
		    	String msg;
		    	switch(cmd){
		    		case "#exit":
		    			obj.leaveGroup(name);
		    			System.exit(0);
		    			break;
	    			case "#listOnline":
	    				obj.listOnline(name);
		    			break;
	    			// case "message":
	    			// 	System.out.println("Digite a mensagem:");
	    			// 	msg = scanner.nextLine().trim();
	    			// 	obj.message(name, msg);
		    		//	break;
		    		default:
		    			obj.message(name, cmd.trim());
		    			break;
		    	}
		    }

		}catch(Exception e){
			System.out.println("Erro no ChatClient: "+e.getMessage());
			e.printStackTrace();
		}


	}
}
