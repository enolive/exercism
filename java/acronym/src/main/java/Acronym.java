import io.vavr.Tuple2;
import io.vavr.collection.CharSeq;

class Acronym {

    private final CharSeq phrase;
    private final CharSeq whitespaces = CharSeq.of(' ', '-');

    Acronym(String phrase) {
        this.phrase = CharSeq.of(phrase);
    }

    String get() {
        return phrase.zip(phrase.prepend(' '))
                .filter(this::previousIsWhitespace)
                .map(this::currentToUpperCase)
                .mkString();
    }

    private char currentToUpperCase(Tuple2<Character, Character> currentPrevious) {
        return currentPrevious.map1(Character::toUpperCase)._1;
    }

    private boolean previousIsWhitespace(Tuple2<Character, Character> currentPrevious) {
        return currentPrevious.map2(whitespaces::contains)._2;
    }

}
