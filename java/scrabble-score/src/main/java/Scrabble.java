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

    private int getScore(Character character) {
        return Match(character).of(
                Case($(isIn('a', 't')), 1),
                Case($('f'), 4)
        );
    }

}
