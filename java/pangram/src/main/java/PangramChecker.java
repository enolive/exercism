import io.vavr.collection.CharSeq;

import java.util.function.Function;

class PangramChecker {
    boolean isPangram(String input) {
        return CharSeq
                .of(input)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .groupBy(Function.identity())
                .size() == 26;
    }
}
