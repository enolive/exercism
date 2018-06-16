import io.vavr.collection.CharSeq;

class Acronym {

    private final CharSeq phrase;

    Acronym(String phrase) {
        this.phrase = CharSeq.of(phrase);
    }

    String get() {
        var acronym = phrase
                .zip(phrase.prepend(' '))
                .filter(l -> l._2 == ' ')
                .map(l -> Character.toUpperCase(l._1))
                .mkString();
        return acronym;
    }

}
