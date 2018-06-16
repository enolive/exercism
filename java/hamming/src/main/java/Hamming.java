import io.vavr.collection.CharSeq;

class Hamming {

    private final CharSeq left;
    private final CharSeq right;

    Hamming(String leftStrand, String rightStrand) {
        requireEqualLength(leftStrand, rightStrand);
        left = CharSeq.of(leftStrand);
        right = CharSeq.of(rightStrand);
    }

    private void requireEqualLength(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return left
                .zipWith(right, this::areEqual)
                .filter(this::notEqual)
                .length();
    }

    private boolean notEqual(Boolean i) {
        return !i;
    }

    private boolean areEqual(char a, char b) {
        return a == b;
    }

}
