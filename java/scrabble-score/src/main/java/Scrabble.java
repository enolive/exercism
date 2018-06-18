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
//        Letter                           Value
//        A, E, I, O, U, L, N, R, S, T       1
//        D, G                               2
//        B, C, M, P                         3
//        F, H, V, W, Y                      4
//        K                                  5
//        J, X                               8
//        Q, Z                               10

        return Match(character).of(
                Case($(isIn('a', 'e', 'i', 'o', 'u', 'r', 's', 't')), 1),
                Case($(isIn('f', 'y')), 4),
                Case($('k'), 5),
                Case($(isIn('q', 'z')), 10)
        );
    }

}
