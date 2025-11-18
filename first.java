import java.io.*;
import java.util.Scanner;

public class FileCopy {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter input filename: ");
        String inputFile = scanner.nextLine();
        
        System.out.print("Enter output filename: ");
        String outputFile = scanner.nextLine();
        
        BufferedReader reader = null;
        BufferedWriter writer = null;
        
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile));
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            
            System.out.println("File copied successfully!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file does not exist");
        } catch (IOException e) {
            System.out.println("Error: No write permission for output file");
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing files");
            }
        }
        
        scanner.close();
    }
}