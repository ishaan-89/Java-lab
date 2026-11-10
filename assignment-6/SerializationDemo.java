import java.io.*;
import java.util.ArrayList;

public class SerializationDemo {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(201, "Aarav Sharma", "IT", 65000));
        employees.add(new Employee(202, "Meera Singh", "HR", 58000));
        employees.add(new Employee(203, "Kabir Verma", "Finance", 72000));

        serializeEmployees(employees);
        deserializeEmployees();
    }

    private static void serializeEmployees(ArrayList<Employee> employees) {
        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            output.writeObject(employees);
            System.out.println("Employee records serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void deserializeEmployees() {
        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ArrayList<Employee> employees =
                    (ArrayList<Employee>) input.readObject();

            System.out.println("\nDeserialized Employee Records:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found: " + e.getMessage());
        }
    }
}
