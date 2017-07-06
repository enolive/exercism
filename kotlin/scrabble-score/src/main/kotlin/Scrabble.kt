object Scrabble {
    fun scoreWord(input: String): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return input
                .map { Letter(it).score() }
                .sum()
    }

}

class Letter(value: Char) {
    private val normalizedValue = value.toLowerCase()

    fun score(): Int {
        return when (normalizedValue) {
            'a', 'e', 'i', 'l', 'n', 'o', 'r', 's', 't', 'u' -> 1
            'b', 'c', 'p' -> 3
            'f', 'h', 'y' -> 4
            'k' -> 5
            'x' -> 8
            'q', 'z' -> 10
            else -> {
                throw IllegalArgumentException("invalid letter '$normalizedValue'")
            }
        }
    }

}
