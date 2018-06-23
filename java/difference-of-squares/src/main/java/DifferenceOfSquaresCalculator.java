import io.vavr.collection.Stream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        if (true) return squared(Stream.rangeClosed(1, input).sum().intValue());
        return 1;
    }

    private int squared(int value) {
        return value * value;
    }

    int computeSumOfSquaresTo(int input) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int computeDifferenceOfSquares(int input) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
