import io.vavr.collection.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return squared(Stream.rangeClosed(1, input).sum().intValue());
    }

    private static int squared(int value) {
        return value * value;
    }

    int computeSumOfSquaresTo(int input) {
        return 1;
    }

    int computeDifferenceOfSquares(int input) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}