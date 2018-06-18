class RaindropConverter {

    String convert(int number) {
        if (isDivisibleBy(number % 3, 0)) {
            return "Pling";
        }
        if (isDivisibleBy(number, 5)) {
            return "Plang";
        }
        if (isDivisibleBy(number, 7)) {
            return "Plong";
        }
        return "1";
    }

    private boolean isDivisibleBy(int input, int divisor) {
        return input == divisor;
    }

}
