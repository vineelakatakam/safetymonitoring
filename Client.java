package finals.finalprojectcs;
//import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.util.Scanner;
public class Client {
  public static void main (String[] args) {
     try {
      Context ic= new InitialContext();

      // Get one proxy object
      // Names in the  java:global JNDI namespace are accessable to any application.
      // (This is how EJB references may be accessed outside the application where
      //  they're defined.)
      Object object_ref = ic.lookup("java:global/finalprojectcs/WindowServerInterface");
      // This narrow downcasts the object_ref to type HelloWorld, this serves as the proxy
    WindowServer proxyW= (WindowServer) PortableRemoteObject.narrow(object_ref,WindowServer.class);


     Object object_ref1 = ic.lookup("java:global/finalprojectcs/DoorServerInterface");
     // This narrow downcasts the object_ref to type HelloWorld, this serves as the proxy
     DoorServer proxyD= (DoorServer) PortableRemoteObject.narrow(object_ref1,DoorServer.class);

        System.out.println("Enter Door/Window Name:");
        // Get the input from User. The Input can be
        // vip-window-1, vip-window-2, rec-door, vip-door
	    Scanner scan = new Scanner(System.in);
         String userinput = scan.next();
        // Prints the status of the Door/Window
        System.out.println(proxyW.getWindowStatus(userinput));
         System.out.println(proxyD.getDoorStatus(userinput));

    }
    catch (NamingException ex) {
        // You might get a naming exception if you forgot to deploy the jar file
        // You might get a naming exception if you forgot to start Glassfish
        System.out.println("Naming exception");
        System.out.println("cause is"+ex.getCause());
        System.out.println("stack trace is ");
        ex.printStackTrace();

 }
 catch (Exception ex) {
      System.out.println(ex);
   }

  } // end Main()


} // end class

