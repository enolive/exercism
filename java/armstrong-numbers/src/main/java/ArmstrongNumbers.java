import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.function.Function;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        List<Integer> digits = Stream
                .unfoldRight(numberToCheck, this::extractDigit)
                .toList();
        int numberOfDigits = digits.length();
        return digits
                .map(powerOf(numberOfDigits))
                .sum()
                .intValue() == numberToCheck;
    }

    private Function<Integer, Integer> powerOf(int numberOfDigits) {
        return d -> (int) Math.pow(d, numberOfDigits);
    }

    private Option<Tuple2<? extends Integer, ? extends Integer>> extractDigit(Integer remain) {
        return remain > 0
                ? Option.of(Tuple.of(remain % 10, remain / 10))
                : Option.none();
    }

}
