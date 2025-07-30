import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    //    int[] multipliers = {1, 2, 1, 2, 1, 2, 1, 2};
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

//        int sum = 0;
//        for (int i = cardNumber.length() - 1; i >= 0; i--) {
//            int positionFromRight = cardNumber.length() - i;
//            int digit = Character.getNumericValue(cardNumber.charAt(i));
//
//            if (positionFromRight % 2 == 0) {
//                int product = digit * 2;
//                sum += (product > 9) ? product - 9 : product;
//            } else {
//
//                sum += digit;
//            }
//        }
//
//        if (sum % 10 == 0) {
//            System.out.println("Incorrect number. Check sum: " + sum);
//        } else {
//            System.out.println("Error: check sum " + sum + " should have 0 in the end.");
//        }


    }

    private static int getTeudatZeutControlDigit(String idNumber) {
        int checkSum = 0;
        for (int i = 0; i < idNumber.length(); i++) {
            int digit = Character.getNumericValue(idNumber.charAt(i));
            int multiplier = i%2 + 1;
            int product = digit * multiplier;

            if (product > 9) {
                int breakdown = product / 10 + product % 10;
                checkSum += breakdown;
            } else {
                checkSum += product;
            }
        }
        int controlDigit = (10 - (checkSum % 10)) % 10;
        return controlDigit;
    }
}