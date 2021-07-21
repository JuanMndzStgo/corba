package example;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class FibonacciServer {
	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPoa.the_POAManager().activate();
			
			FibonacciImp fiboImp = new FibonacciImp();

			Object ref = rootPoa.servant_to_reference(fiboImp);
			Fibonacci href = FibonacciHelper.narrow(ref);

			Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt rootContext = NamingContextExtHelper.narrow(objRef);
			
			NameComponent nameComponent[] = rootContext.to_name("Fibonacci");
			rootContext.rebind(nameComponent, href);

			System.out.println("Servidor... listo y en espera");
			orb.run();
			
		}catch(Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
