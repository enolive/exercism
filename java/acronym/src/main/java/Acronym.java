import io.vavr.Tuple2;
import io.vavr.collection.CharSeq;

class Acronym {

    private final CharSeq phrase;

    Acronym(String phrase) {
        this.phrase = CharSeq.of(phrase);
    }

    String get() {
        return phrase
                .zip(phrase.prepend(' '))
                .filter(this::previousIsWhitespace)
                .map(this::upperCase)
                .mkString();
    }

    private char upperCase(Tuple2<Character, Character> l) {
        return Character.toUpperCase(l._1);
    }

    private boolean previousIsWhitespace(Tuple2<Character, Character> l) {
        return l._2 == ' ';
    }

}
