import java.io.*;

public class FileHandling {
    private static final String SOURCE = "input.bin";
    private static final String COPY = "copy.bin";
    private static final String STUDENT_FILE = "students.txt";

    public static void main(String[] args) {
        copyBinaryFile(SOURCE, COPY);
        writeStudentDetails(STUDENT_FILE);
        readStudentDetails(STUDENT_FILE);
    }

    // Byte streams are used for copying binary files.
    private static void copyBinaryFile(String source, String destination) {
        try (FileInputStream input = new FileInputStream(source);
             FileOutputStream output = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            System.out.println("Binary file copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    // Character streams are used to write text data.
    private static void writeStudentDetails(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("101,Ananya,Computer Engineering,9.1\n");
            writer.write("102,Rahul,Electrical Engineering,8.7\n");
            writer.write("103,Simran,Mechanical Engineering,9.0\n");
            System.out.println("Student details written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student details: " + e.getMessage());
        }
    }

    // Character streams are used to read text data.
    private static void readStudentDetails(String fileName) {
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            System.out.println("\nStudent Records:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading student details: " + e.getMessage());
        }
    }
}
