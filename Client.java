
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    
    public Client() {
        
    }
    
    public static void main(String[] args) {
        try {

            if (args.length != 2) {
                System.err.println("usage: java Client ___ ___");
                System.exit(1);
            }

            if (args[0].equals("pctwhite")) {

                try {
                    Double.parseDouble(args[1]);
                } catch (Exception e) {
                    System.err.println("usage: java pctwhite <number>");
                }
            }

            if (args[0].equals("list")) {

                try {
                    Integer.parseInt(args[1]);
                } catch (Exception e) {
                    System.err.println("usage: java list <number>");
                }
            }

            String host = "localhost";
            int PORT = 1069;
            
            //Getting the registry with host is local host and port is 1069
            Registry registry = LocateRegistry.getRegistry(host, PORT);
            
            //stub like gateway looking up the registry for the remote object
            IPerson stub = (IPerson) registry.lookup("Person");
            
            //calling the method
            List<Person> persons = stub.getPerson();

            //A user wants to find whether an input surname is available
            //Command format: java Client find "surname"
            if (args[0].equals("find")) {
                for (Person p: persons) {
                    if (p.getName().equals(args[1])) {
                        System.out.println("TRUE");
                        System.exit(1);
                    } 
                }
                System.out.println("FALSE");
            }
           
            //Input a pctwhite, return all the surnames have pctwhite smaller than the given.
            //Command format: java Client pctwhite <number>
            if (args[0].equals("pctwhite")) {
                for (Person p: persons) {
                    if (p.getPctwhite() < Double.parseDouble(args[1])) {
                        System.out.println(p.getName());
                    } 
                }
            }

            //A user wants to list all Person whose count is larger than a given. 
            //Command format: java Client list <number>
            if (args[0].equals("list")) {
                for (Person p: persons) {
                    if (p.getCount() < Integer.parseInt(args[1])) {
                        System.out.println(p.getName() + "," + p.getCount() + "," 
                            + p.getPctwhite() + "," + p.getPctblack());
                    } 
                }
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
