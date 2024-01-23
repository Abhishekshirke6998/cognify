import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class level2task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for operation (encryption or decryption)
        System.out.print("Choose operation (1 for encryption, 2 for decryption): ");
        int operation = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Prompt user for file name or path
        System.out.print("Enter file name or path: ");
        String inputFileName = scanner.nextLine();

        // Prompt user for output file name
        System.out.print("Enter output file name: ");
        String outputFileName = scanner.nextLine();

        // Perform chosen operation
        try {

            if (operation == 1) {
                encryptFile(inputFileName, outputFileName);
                System.out.println("Encryption completed. Result saved to " + outputFileName);
            } else if (operation == 2) {
                decryptFile(inputFileName, outputFileName);
                System.out.println("Decryption completed. Result saved to " + outputFileName);
            } else {
                System.out.println("Invalid operation choice. Please choose 1 for encryption or 2 for decryption.");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();

    }

    public static void encryptFile(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                // Perform simple encryption (you can replace this with your own encryption
                // logic)
                ch = ch + 1;
                writer.write(ch);

            }

        }

    }

    public static void decryptFile(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                // Perform simple decryption (you can replace this with your own decryption
                // logic)
                ch = ch - 1;
                writer.write(ch);

            }

        }

    }

}
