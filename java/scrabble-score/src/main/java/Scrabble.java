import io.vavr.collection.CharSeq;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;

class Scrabble {

    private final CharSeq word;

    Scrabble(String word) {
        this.word = CharSeq.of(word).toLowerCase();
    }

    int getScore() {
        return word
                .map(this::getScore)
                .sum()
                .intValue();
    }

    private int getScore(char character) {
        return Match(character).of(
                Case($(isIn('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't')), 1),
                Case($(isIn('d', 'g')), 2),
                Case($(isIn('b', 'c', 'm', 'p')), 3),
                Case($(isIn('f', 'h', 'v', 'w', 'y')), 4),
                Case($('k'), 5),
                Case($(isIn('j', 'x')), 8),
                Case($(isIn('q', 'z')), 10)
        );
    }

}
