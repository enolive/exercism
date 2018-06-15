import io.vavr.collection.CharSeq;

import java.text.MessageFormat;

class RnaTranscription {
    String transcribe(String dnaStrand) {
        return CharSeq.of(dnaStrand).map(this::transcribeSymbol).mkString();
    }

    private char transcribeSymbol(char symbol) {
        switch (symbol) {
            case 'G':
                return 'C';
            case 'C':
                return 'G';
            case 'T':
                return 'A';
            case 'A':
                return 'U';
            default:
                throw new IllegalArgumentException(MessageFormat.format("Unknown symbol {0}.", symbol));
        }
    }
}