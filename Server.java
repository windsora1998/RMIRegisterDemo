import java.rmi.server.*;
import java.rmi.registry.*;
import java.rmi.RemoteException;

public class Server extends ImplPerson {

	public Server() throws RemoteException {

	}

	public static void main(String[] args) {

		try {

			int PORT = 1069;

			//Installing the implement Person class
			//It is the remote
			ImplPerson person = new ImplPerson();

			//Exporting the object in the ImplPerson class
			//(Person extends Remote, so this is exporting the remote object to the skeleton)
			//skeleton using stub protocol
			//Peron is remote object to be exported and 0 is port to export the object on
			IPerson skeleton = (IPerson) UnicastRemoteObject.exportObject(person, 0);

			//Binding the remote object (stub) in the registry
			Registry registry = LocateRegistry.getRegistry(PORT);
			registry.rebind("Person", skeleton);

			System.err.println("Sever started ...");

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}