package utils;
public class CheckUtils {
    public static boolean isCardNumberValid(String cardNumber) {
        int checkSum = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int positionFromRight = cardNumber.length() - i;
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            checkSum = getCheckSum(2 - i %2, digit, checkSum);
        }
        return (checkSum % 10 == 0)? true : false;
    }

    public static int getTeudatZeutControlDigit(String idNumber) {
        int checkSum = 0;
        for (int i = 0; i < idNumber.length(); i++) {
            int digit = Character.getNumericValue(idNumber.charAt(i));
            checkSum = getCheckSum(i%2 + 1, digit, checkSum);
        }
        return (10 - (checkSum % 10)) % 10;
    }

    private static int getCheckSum(int multiplier, int digit, int checkSum) {
        int product = digit * multiplier;
        checkSum += product / 10 + product % 10;
        return checkSum;
    }
}
