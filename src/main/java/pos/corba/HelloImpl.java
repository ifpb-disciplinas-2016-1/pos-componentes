package pos.corba;

import org.omg.CORBA.*;

public class HelloImpl extends HelloPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }
    // Implement sayHello() method

    public String sayHello() {
        return "\nHello world :)!!\n";
    }
    // Implement shutdown() method

    public void shutdown() {
        orb.shutdown(false);
    }
}
