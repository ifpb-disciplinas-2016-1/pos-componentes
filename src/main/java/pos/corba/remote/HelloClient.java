package pos.corba.remote;

import org.omg.CosNaming.*;
import org.omg.CORBA.Object;
import org.omg.CORBA.*;
import pos.corba.Hello;
import pos.corba.HelloHelper;

public class HelloClient {

    static Hello helloImpl;

    public static void main(String args[]) {
        try {
            // Create and initialize the ORB.
            ORB orb = ORB.init(args, System.getProperties()); // Get the root naming context.
            Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is // part of the Interoperable Naming Service. 
            NamingContextExt context = NamingContextExtHelper.narrow(objRef);
            // Resolve the Object reference in Naming.
            
            
            System.out.println("Contexto:\t"+context);
            
            String name = "Hello";
            System.out.println("Objeto:\t"+context.resolve_str(name));
            helloImpl = HelloHelper.narrow(context.resolve_str(name));
            System.out.println("Obtained a handle on server object: " + helloImpl);
            System.out.println("Mensagem:" +helloImpl.sayHello());
            System.out.println("Segunda Mensagem:" +helloImpl.sayHello());
//            helloImpl.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
