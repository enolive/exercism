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
//	    int firstDigit = numberToCheck % 10;
//	    int secondDigit = numberToCheck / 10;
//	    int thirdDigit = numberToCheck / 100;
//	    int sum = (int) (Math.pow(firstDigit, 1) + Math.pow(secondDigit, 2) + Math.pow(thirdDigit, 3));
        return sum == numberToCheck;
    }

}
