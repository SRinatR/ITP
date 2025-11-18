import java.io.*;
import java.util.Scanner;

public class DivisionProgram {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
        
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(filename));
            
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            
            if (line1 == null || line2 == null) {
                System.out.println("Error: File does not contain enough data");
                return;
            }
            
            int num1 = Integer.parseInt(line1.trim());
            int num2 = Integer.parseInt(line2.trim());
            
            int result = num1 / num2;
            
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File does not exist");
        } catch (NumberFormatException e) {
            System.out.println("Error: File contains non-integer values");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        } catch (IOException e) {
            System.out.println("Error: Unable to read file");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
        
        scanner.close();
    }
}