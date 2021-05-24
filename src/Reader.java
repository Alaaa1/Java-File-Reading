import java.io.*;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        String fileName = "Student.txt";
        Scanner inputStream;
        PrintWriter outputFile;
        try {
            inputStream = new Scanner(new File(fileName));
            outputFile = new PrintWriter("Result.txt");
            while(inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                String[] array = line.split(",");
                String firstName = array[0];
                String lastName = array[1];
                int test1 = Integer.parseInt(array[2]);
                int test2 = Integer.parseInt(array[3]);
                int finalExam = Integer.parseInt(array[4]);
                double total = (test1 * 0.2) + (test2*0.2) + (finalExam * 0.6);
                if (total >= 60) outputFile.println(firstName + " " + lastName + " " + total + " PASS");
            }
            inputStream.close();
            outputFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found check the file's name");
            System.exit(0);
        }
        catch (IOError e) {
            System.out.println("Problem with input from file"+fileName);
        }
    }
}
