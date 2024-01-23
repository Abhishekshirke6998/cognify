import java.util.Scanner;

public class level2task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get password input from the user
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check password strength
        String result = checkPasswordStrength(password);

        // Display the result
        System.out.println(result);

        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        // Define criteria for password strength
        boolean lengthCriteria = password.length() >= 8;
        boolean uppercaseCriteria = false;
        boolean lowercaseCriteria = false;
        boolean digitCriteria = false;
        boolean specialCharCriteria = false;

        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                uppercaseCriteria = true;
            } else if (Character.isLowerCase(character)) {
                lowercaseCriteria = true;
            } else if (Character.isDigit(character)) {
                digitCriteria = true;
            } else if (isSpecialCharacter(character)) {
                specialCharCriteria = true;
            }
        }

        // Evaluate password strength
        if (lengthCriteria && uppercaseCriteria && lowercaseCriteria && digitCriteria && specialCharCriteria) {
            return "Strong password! =M";
        } else {
            StringBuilder feedback = new StringBuilder("Weak password. Consider the following improvements:");
            if (!lengthCriteria) {
                feedback.append("\n- Password should be at least 8 characters long.");
            }
            if (!uppercaseCriteria) {
                feedback.append("\n- Include at least one uppercase letter.");
            }
            if (!lowercaseCriteria) {
                feedback.append("\n- Include at least one lowercase letter.");
            }
            if (!digitCriteria) {
                feedback.append("\n- Include at least one digit.");
            }
            if (!specialCharCriteria) {
                feedback.append("\n- Include at least one special character.");
            }
            return feedback.toString();
        }
    }

    private static boolean isSpecialCharacter(char character) {
        // Add your desired special characters here
        String specialCharacters = "!@#$%^&*(),.?\":{}|<>";
        return specialCharacters.indexOf(character) != -1;
    }
}
