object Scrabble {
    fun scoreWord(input: String): Int {
        return input
                .filter { !it.isWhitespace() }
                .map { Letter(it).score() }
                .sum()
    }

}

class Letter(value: Char) {
    private val normalizedValue = value.toLowerCase()

    fun score(): Int {
        return when (normalizedValue) {
            'a', 'e', 'i', 'l', 'n', 'o', 'r', 's', 't', 'u' -> 1
            'd', 'g' -> 2
            'b', 'c', 'm', 'p' -> 3
            'f', 'h', 'y' -> 4
            'k' -> 5
            'j', 'x' -> 8
            'q', 'z' -> 10
            else -> {
                throw IllegalArgumentException("invalid letter '$normalizedValue'")
            }
        }
    }

}
