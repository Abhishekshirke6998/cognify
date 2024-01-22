import java.util.Scanner;
import java.security.SecureRandom;
public class level1task4 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for password length
        System.out.print("Enter the desired length of the password: ");
        int passwordLength = scanner.nextInt();

        // Get user preferences for password composition
        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        // Generate the password based on user preferences
        String password = generatePassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);

        // Display the generated password
        System.out.println("Generated Password: " + password);

        // Close the scanner
        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                           boolean includeUppercase, boolean includeSpecialChars) {
        // Define character sets based on user preferences
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\"<>,.?/";

        // Create a pool of characters based on user preferences
        StringBuilder charPool = new StringBuilder();
        if (includeNumbers) charPool.append(numbers);
        if (includeLowercase) charPool.append(lowercase);
        if (includeUppercase) charPool.append(uppercase);
        if (includeSpecialChars) charPool.append(specialChars);

        // Check if at least one character set is selected
        if (charPool.length() == 0) {
            System.out.println("Error: Please select at least one character set.");
            System.exit(1);
        }

        // Generate the password using SecureRandom
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length());
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }
}

