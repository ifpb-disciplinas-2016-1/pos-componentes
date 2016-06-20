package pos.corba.remote;

import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import pos.corba.Hello;
import pos.corba.HelloHelper;
import pos.corba.HelloImpl;

public class HelloServer {

    public static void main(String args[]) {
        try {
            Properties p = new Properties();
            p.put("ORBInitialPort", "1050");
            p.put("ORBInitialHost", "localhost");
            // Create and initialize the ORB
            ORB orb = ORB.init(args, p);
            // Get reference to rootpoa
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // Create servant and register it with the ORB
            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(orb);
            // Get object reference from the servant
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(helloImpl);
            Hello hello = HelloHelper.narrow(ref);
            // Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt, which is part of the Interoperable // Naming Service (INS) specification
            NamingContextExt context = NamingContextExtHelper.narrow(objRef);
            // Bind the Object reference in Naming
            
            String name = "Hello";
            NameComponent path[] = context.to_name(name);
            context.rebind(path, hello);
            // Activate the POAManager
            rootPOA.the_POAManager().activate();
            
            System.out.println("HelloServer ready and waiting ...");
            
            System.out.println(orb.object_to_string(hello));
            // Wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("HelloServer Exiting ...");
    }
}
