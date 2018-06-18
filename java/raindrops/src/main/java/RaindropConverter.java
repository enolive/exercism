import io.vavr.Tuple;
import io.vavr.collection.List;
import io.vavr.control.Option;

class RaindropConverter {

    String convert(int number) {
        var rules = List.of(
                Tuple.of(isDivisibleBy(number, 3), "Pling"),
                Tuple.of(isDivisibleBy(number, 5), "Plang"),
                Tuple.of(isDivisibleBy(number, 7), "Plong")
        );
        var result = rules
                .filter(r -> r._1)
                .map(r -> r._2)
                .mkString();
        return Option
                .of(result)
                .filter(s -> !s.isEmpty())
                .getOrElse(() -> Integer.toString(number));
    }

    private boolean isDivisibleBy(int input, int divisor) {
        return input % divisor == 0;
    }

}
