/* 
	this is the class implement class interface person object
	The person read from file app_c_new.csv
	reference from https://www.javatpoint.com/RMI

*/

import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImplPerson implements IPerson {

	public ImplPerson() throws RemoteException {
		super();
	}

	@Override
	public List<Person> getPerson() {
		//Create list person
		List<Person> persons = new ArrayList<Person>();
		
		//Current forder contains file app_c_new.csv	
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		
		String csvFile = s + "/app_c_new.csv";
	    String line = "";
	    String cvsSplitBy = ",";

	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	    	br.readLine(); //read the first line

	        while ((line = br.readLine()) != null) {

	        	//get information person by second line to file empty 
	            String[] person = line.split(cvsSplitBy);
	            String name = person[0];
	            int count = Integer.parseInt(person[1]);
	            double pctwhite = Double.parseDouble(person[2]); 
	            double pctblack = Double.parseDouble(person[3]);

	            Person p = new Person();
	            p.setName(name);
	            p.setCount(count);
	            p.setPctwhite(pctwhite);
	            p.setPctblack(pctblack);

	            persons.add(p);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return persons;
	}
}