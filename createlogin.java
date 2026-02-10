package createLogin;

import java.util.Scanner;

public class createlogin {
    static Scanner scan = new Scanner(System.in);
    
    public static String[] getLoginCredentials() {
        System.out.println("Enter a username");
        String Username = scan.nextLine();
        
        System.out.println("Enter a password");
        String Password = scan.nextLine();
        return new String[]{Username, Password};
    }
}
