import io.vavr.collection.CharSeq;

import static io.vavr.API.*;

class Scrabble {

    private final CharSeq word;

    Scrabble(String word) {
        this.word = CharSeq.of(word);
    }

    int getScore() {
        return getScore(word.head());
    }

    private int getScore(Character character) {
        return Match(character).of(
                Case($('a'), 1)
        );
    }

}
