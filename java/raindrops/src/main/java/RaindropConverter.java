import io.vavr.Function1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;

class RaindropConverter {

    String convert(int number) {
        if (number % 3 == 0) {
            return "Pling";
        }
        if (number == 5) {
            return "Plang";
        }
        if (number == 7) {
            return "Plong";
        }
        return "1";
    }

}
