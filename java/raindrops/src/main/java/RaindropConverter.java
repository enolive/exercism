import io.vavr.Function1;
import io.vavr.collection.Stream;

class RaindropConverter {

    private static final Function1<Integer, String> SEQUENCE = sequence().memoized();

    private static Stream<String> sequence() {
        final var plings = Stream.of("", "", "Pling").cycle();
        final var plangs = Stream.of("", "", "", "", "Plang").cycle();
        final var plongs = Stream.of("", "", "", "", "", "", "Plong").cycle();
        final var words = plings.zipWith(plangs, String::concat).zipWith(plongs, String::concat);
        final var numbers = Stream.from(1).map(String::valueOf);
        return words.zipWith(numbers, (word, num) -> word.isEmpty() ? num : word);
    }

    String convert(int number) {
        return SEQUENCE.apply(number - 1);
    }
}
