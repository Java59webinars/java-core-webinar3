package utils;
public class CheckUtils {
    public static boolean isCardNumberValid(String cardNumber) {
        int checkSum = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int positionFromRight = cardNumber.length() - i;
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            int multiplier = 2 - i%2;
            int product = digit * multiplier;
            checkSum += product / 10 + product % 10;
        }
        return (checkSum % 10 == 0)? true : false;
    }

    public static int getTeudatZeutControlDigit(String idNumber) {
        int checkSum = 0;
        for (int i = 0; i < idNumber.length(); i++) {
            int digit = Character.getNumericValue(idNumber.charAt(i));
            int multiplier = i%2 + 1;
            int product = digit * multiplier;
            checkSum += product / 10 + product % 10;
        }
        return (10 - (checkSum % 10)) % 10;
    }

}
