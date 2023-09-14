import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class logAuth {
    private static Map<String, String> users = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the authentication system!");
            System.out.println("1: Register");
            System.out.println("2: Login");
            System.out.println("3: Exit");
            System.out.println("Please choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.println("Enter a Username: ");
        String username = scanner.next();
        if (users.containsKey(username)) {
            System.out.println("Username already exist! Please choose another username");
            return;
        }
        System.out.println("Enter a Password: ");
        String password = scanner.next();
        users.put(username, password);
        System.out.println("Registration Succcessful!");
    }


    private static void loginUser(Scanner scanner) {
        System.out.println("Enter Your Username: ");
        String username = scanner.next();
        System.out.println("Enter Your Password: ");
        String password = scanner.next();
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                System.out.println("Login Successful! Now you can access secured page.");
            } else {
                System.out.println("Incorrect Password! Please try again.");
            }
        } else {
            System.out.println("Username not found! Please register first.");
        }
    }
}