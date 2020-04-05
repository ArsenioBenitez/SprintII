import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 

public class BPServer implements MyRemote {
	
	public BPServer() {}
	
	public String sayHello() {
	        return "Hello, world!";
	}

	public static void main(String[] args) {
		try {
            BPServer obj = new BPServer();
            MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("MyRemote", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

	}

}
