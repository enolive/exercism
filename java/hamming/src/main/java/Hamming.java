import io.vavr.collection.CharSeq;

class Hamming {

    private final CharSeq left;
    private final CharSeq right;

    Hamming(String leftStrand, String rightStrand) {
        left = CharSeq.of(leftStrand);
        right = CharSeq.of(rightStrand);
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
