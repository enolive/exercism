import io.vavr.control.Option;

import java.text.MessageFormat;

class Twofer {
    String twofer(String name) {
        return Option
                .of(name)
                .filter(s -> !s.isEmpty())
                .orElse(Option.of("you"))
                .map(this::formatMessage)
                .get();
    }

    private String formatMessage(String name) {
        return MessageFormat.format("One for {0}, one for me.", name);
    }
}