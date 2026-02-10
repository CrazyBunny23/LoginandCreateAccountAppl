package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Wcfiles {


     public static void createUfile(String Username) throws IOException {
        File Ufile = new File("User.txt");

        FileWriter fw = new FileWriter(Ufile, true); // true = append mode

        PrintWriter pw = new PrintWriter(fw);

        pw.println(Username); // println adds newline automatically
        pw.close();
    }

public static void createPfile(String Password) throws IOException {
    File Pfile = new File("Pass.txt");

    FileWriter fw = new FileWriter(Pfile, true); // true = append mode

    PrintWriter pw = new PrintWriter(fw);

    pw.println(Password); // println adds newline automatically
    pw.close();
}

    public static int findUsernameInFile(String username) {
        try (Scanner fileScanner = new Scanner(new File("User.txt"))) {
            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {
                if (fileScanner.nextLine().equals(username)) {
                    return lineNumber;
                }
                lineNumber++;
            }
        } catch (Exception e) {
            System.out.println("Error reading username file: " + e.getMessage());
        }
        return -1; // Username not found
    }

    public static String readPasswordFromFile(int lineNumber) {
        try (Scanner fileScanner = new Scanner(new File("Pass.txt"))) {
            for (int i = 1; i < lineNumber; i++) {
                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine(); // Skip lines
                }
            }
            if (fileScanner.hasNextLine()) {
                return fileScanner.nextLine();
            }
            } catch (Exception e) {
                System.out.println("Error reading password file: " + e.getMessage());
            }
            return null;
        }
    }
    

