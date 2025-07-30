import java.util.Scanner;
import static utils.CheckUtils.*;

public class Main {
    public static void main(String[] args) {
    //31175641, 5326146208680741
        Scanner scanner = new Scanner(System.in);
        String idNumber = "";
        while (!idNumber.matches("\\d{8}") ){
            System.out.printf("Enter your number teudat zeut without control digit (8 digits): ");
            idNumber = scanner.nextLine();
        }
        int controlDigit = getTeudatZeutControlDigit(idNumber);
        System.out.println("Control digit: " + controlDigit);
        System.out.printf("Enter your number debit card: ");
        String cardNumber = scanner.nextLine();
        if (!cardNumber.matches("\\d{16}")) {
            System.out.println("Error: The number should have 16 digits.");
            return;
        }
        String correctMessage = "Correct number";
        String errorMessage = "Error: Incorrect check sum";
        System.out.println( isCardNumberValid(cardNumber)?correctMessage :errorMessage );
        isCardNumberValid(cardNumber);
    }

    }