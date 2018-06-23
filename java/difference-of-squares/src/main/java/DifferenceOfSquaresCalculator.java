import io.vavr.Function1;

class DifferenceOfSquaresCalculator {

    private static int sumUpTo(int input) {
        return input * (input + 1) / 2;
    }

    private static int squared(int value) {
        return value * value;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

    int computeSquareOfSumTo(int input) {
        return Function1
                .of(DifferenceOfSquaresCalculator::sumUpTo)
                .andThen(DifferenceOfSquaresCalculator::squared)
                .apply(input);
    }

    int computeSumOfSquaresTo(int input) {
        return squarePyramidalNumber(input);
    }

    private static int squarePyramidalNumber(int input) {
        return input * (input + 1) * (2 * input + 1) / 6;
    }

}
