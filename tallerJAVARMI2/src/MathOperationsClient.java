import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MathOperationsClient {
    public static void main(String[] args) {
        try {
            // Conectar al registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost");
            MathOperationsInterface stub = (MathOperationsInterface) registry.lookup("MathOperations");

            Scanner scanner = new Scanner(System.in);

            // Pedir al usuario que ingrese dos números
            System.out.print("Ingrese el primer número: ");
            int num1 = scanner.nextInt();
            System.out.print("Ingrese el segundo número: ");
            int num2 = scanner.nextInt();

            // Realizar operaciones
            System.out.println("Suma: " + stub.add(num1, num2));
            System.out.println("Resta: " + stub.subtract(num1, num2));
            System.out.println("Multiplicación: " + stub.multiply(num1, num2));
            System.out.println("División: " + stub.divide(num1, num2));

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e);
        }
    }
}
