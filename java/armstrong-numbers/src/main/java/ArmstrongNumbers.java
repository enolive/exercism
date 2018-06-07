class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
	    int sum = 0;
	    int numberOfDigits = (int) Math.log10(numberToCheck) + 1;
	    int remaining = numberToCheck;
        while (remaining > 0) {
            int currentDigit = remaining % 10;
            sum = (int) (sum + Math.pow(currentDigit, numberOfDigits));
            remaining = remaining / 10;
        }
        return sum == numberToCheck;
    }

}
