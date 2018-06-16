import io.vavr.API;
import io.vavr.Tuple2;
import io.vavr.collection.CharSeq;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Tuple2;

class Acronym {

    private final CharSeq phrase;

    Acronym(String phrase) {
        this.phrase = CharSeq.of(phrase);
    }

    String get() {
        return phrase.zip(phrase.prepend(' '))
                .filter(this::previousIsWhitespace)
                .map(this::upperCase)
                .mkString();
    }

    private char upperCase(Tuple2<Character, Character> l) {
        return Character.toUpperCase(l._1);
    }

    private boolean previousIsWhitespace(Tuple2<Character, Character> l) {
        return Match(l).of(
                Case($Tuple2($(), $(' ')), true),
                Case($(), false)
        );
    }

}
