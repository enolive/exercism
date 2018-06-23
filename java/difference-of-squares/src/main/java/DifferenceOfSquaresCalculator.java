import io.vavr.collection.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return squared(sumUpTo(input));
    }

    private int sumUpTo(int input) {
        return input * (input + 1) / 2;
    }

    private static int squared(int value) {
        return value * value;
    }

    int computeSumOfSquaresTo(int input) {
        return Stream.rangeClosed(1, input)
                .map(DifferenceOfSquaresCalculator::squared)
                .sum()
                .intValue();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
