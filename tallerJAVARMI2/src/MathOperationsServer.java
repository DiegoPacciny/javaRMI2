import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MathOperationsServer extends UnicastRemoteObject implements MathOperationsInterface {
    protected MathOperationsServer() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division by zero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            MathOperationsServer server = new MathOperationsServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MathOperations", server);
            System.out.println("Servidor listo");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
