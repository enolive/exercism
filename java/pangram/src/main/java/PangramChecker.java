import io.vavr.collection.CharSeq;

import java.util.function.Function;

class PangramChecker {
    private final CharSeq alphabet = CharSeq.rangeClosed('a', 'z');

    boolean isPangram(String input) {
        return CharSeq
                .of(input)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .groupBy(Function.identity())
                .length() == alphabet.length();
    }
}
