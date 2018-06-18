import io.vavr.Function1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;

class RaindropConverter {

    private final List<Tuple2<Function1<Integer, Boolean>, String>> rules = List.of(
            Tuple.of(numbersDivisibleBy(3), "Pling"),
            Tuple.of(numbersDivisibleBy(5), "Plang"),
            Tuple.of(numbersDivisibleBy(7), "Plong")
    );

    String convert(int number) {
        return Option
                .of(getResultFromRules(number))
                .filter(result -> !result.isEmpty())
                .getOrElse(() -> Integer.toString(number));
    }

    private String getResultFromRules(int number) {
        return rules
                .filter(r -> r._1.apply(number))
                .map(r -> r._2)
                .mkString();
    }

    private Function1<Integer, Boolean> numbersDivisibleBy(int divisor) {
        return input -> input % divisor == 0;
    }
}
