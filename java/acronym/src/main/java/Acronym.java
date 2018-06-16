import io.vavr.Tuple2;
import io.vavr.collection.CharSeq;

class Acronym {

    private final CharSeq phrase;

    Acronym(String phrase) {
        this.phrase = CharSeq.of(phrase);
    }

    String get() {
        return phrase.zip(phrase.prepend(' '))
                .filter(this::previousIsWhitespaceOrHyphen)
                .map(this::upperCase)
                .mkString();
    }

    private char upperCase(Tuple2<Character, Character> currentPrevious) {
        return currentPrevious.map1(Character::toUpperCase)._1;
    }

    private boolean previousIsWhitespaceOrHyphen(Tuple2<Character, Character> currentPrevious) {
        return currentPrevious.map2(previous -> CharSeq.of(' ', '-').contains(previous))._2;
    }

}
