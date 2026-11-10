import java.io.*;

public class LogAnalyzer {
    private static final String INPUT_FILE = "application.log";
    private static final String OUTPUT_FILE = "filtered.log";

    public static void main(String[] args) {
        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                totalEntries++;
                String upperLine = line.toUpperCase();

                if (upperLine.contains("ERROR") || upperLine.contains("WARNING")) {
                    writer.write(line);
                    writer.newLine();

                    if (upperLine.contains("ERROR")) {
                        errorCount++;
                    }
                    if (upperLine.contains("WARNING")) {
                        warningCount++;
                    }
                }
            }

            System.out.println("Total log entries: " + totalEntries);
            System.out.println("ERROR entries: " + errorCount);
            System.out.println("WARNING entries: " + warningCount);
            System.out.println("Filtered entries saved to " + OUTPUT_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Log file not found: " + INPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error processing log file: " + e.getMessage());
        }
    }
}
