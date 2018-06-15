import io.vavr.collection.CharSeq;

import static io.vavr.API.*;

class RnaTranscription {
    String transcribe(String dnaStrand) {
        return CharSeq
                .of(dnaStrand)
                .map(this::transcribeSymbol)
                .mkString();
    }

    private char transcribeSymbol(char symbol) {
        return Match(symbol).of(
                Case($('G'), 'C'),
                Case($('C'), 'G'),
                Case($('T'), 'A'),
                Case($('A'), 'U')
        );
    }
}