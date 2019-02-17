/* 
	this is the class interface person object
	The person read from file app_c_new.csv
	reference from https://www.javatpoint.com/RMI
*/

import java.rmi.*;
import java.util.*;

public interface IPerson extends Remote {

	//Method get information Person
	public List<Person> getPerson() throws RemoteException;
	
}
