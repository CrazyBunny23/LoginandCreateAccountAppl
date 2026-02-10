import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;
import static createLogin.createlogin.getLoginCredentials;
import static files.Wcfiles.createPfile;
import static files.Wcfiles.createUfile;
import static files.Wcfiles.findUsernameInFile;
import static files.Wcfiles.readPasswordFromFile;


public class Main {
   static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        
        int choice;
        do {
            System.out.println("----------------------------------");
            System.out.println("Option 1: Create Login");
            System.out.println("Option 2: Login");
            System.out.println("Option 3: Exit");
            System.out.println("----------------------------------");
            choice = scan.nextInt();
            scan.nextLine(); // Consume the leftover newline
            switch(choice) {
                case 1 -> {
                    String[] credentials = createLogin.createlogin.getLoginCredentials();
                    createUfile(credentials[0]);
                    createPfile(credentials[1]);
                }
                case 2 -> Login();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Choose option 1 or 2");
            }
        } while (choice != 3);
    }

    public static void Login() {
        System.out.println("Enter your username");
        String username = scan.nextLine();
        System.out.println("Enter your password");
        String password = scan.nextLine();
       
        int lineNumber = findUsernameInFile(username);
        
        if (lineNumber != -1 && password.equals(readPasswordFromFile(lineNumber))) {
            System.out.println("Login successful!");
                int postloginchoice;
                do {
                    System.out.println("-----------------------");
                    System.out.println("Option 1: Add User Information");
                    System.out.println("View User Information");
                    System.out.println("Option 3: Play a game");
                    System.out.println("Option 4: Logout");
                    System.out.println("-----------------------");
                    postloginchoice = scan.nextInt();
                    scan.nextLine(); // Consume the leftover newline
                    switch(postloginchoice) {
                        case 1 -> System.out.println("Add User Information");
                        case 2 -> System.out.println("View User Information");
                        case 3 -> System.out.println("Play a game");
                        case 4 -> System.out.println("Logging out...");
                        default -> System.out.println("Choose option 1, 2, 3 or 4");
                    }
                } while (postloginchoice != 4);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

}