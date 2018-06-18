class RaindropConverter {

    String convert(int number) {
        if (isDivisibleBy(number, 3)) {
            return "Pling";
        }
        if (isDivisibleBy(number, 5)) {
            return "Plang";
        }
        if (isDivisibleBy(number, 7)) {
            return "Plong";
        }
        return Integer.toString(number);
    }

    private boolean isDivisibleBy(int input, int divisor) {
        return input % divisor == 0;
    }

}
