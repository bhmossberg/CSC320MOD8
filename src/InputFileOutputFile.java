import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputFileOutputFile {

    public static void main(String[] args) {
        String inputFile = "TestInput.txt";
        String outputFile = "TestOutput.txt";

        System.out.println("=== File Input / Output Demonstration ===\n");

        // Step 1: Read the file
        String content = readFile(inputFile);

        if (content == null) {
            System.out.println("Program cannot continue without input file.");
            return;
        }

        System.out.println("=== Original File Content ===");
        System.out.println(content);

        // Step 2: Let the user modify the content
        String modifiedContent = modifyContent(content);

        // Step 3: Write the (modified) content to output file
        printToFile(modifiedContent, outputFile);
    }

    // ====================== READ FILE ======================
    private static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (Scanner fileScanner = new Scanner(new FileInputStream(fileName))) {
            
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
            System.out.println("Successfully read from: " + fileName);
            
        } catch (IOException e) {
            System.out.println("Failure: Could not read file '" + fileName + "'");
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return content.toString();
    }

    // ====================== MODIFY CONTENT ======================
    private static String modifyContent(String originalContent) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("\nWould you like to modify the content? (Y/N)");
        String choice = userInput.nextLine().trim().toUpperCase();

        if (choice.equals("Y")) {
            System.out.println("\nEnter your modified text (type 'END' on a new line when finished):");
            StringBuilder newContent = new StringBuilder();

            String line;
            while (!(line = userInput.nextLine()).equalsIgnoreCase("END")) {
                newContent.append(line).append("\n");
            }
            System.out.println("Content modified by user.");
            return newContent.toString();
        } else {
            System.out.println("Keeping original content.");
            return originalContent;
        }
    }

    // ====================== WRITE TO FILE ======================
    private static void printToFile(String content, String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            
            pw.print(content);                    // Write the content as-is
            
            System.out.println("\nSuccess: Information written to '" + fileName + "'");
            
        } catch (IOException e) {
            System.out.println("Failure: Could not write to file '" + fileName + "'");
            System.out.println("Error: " + e.getMessage());
        }
    }
}